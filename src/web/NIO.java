package web;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIO {
    private Selector selector;
    private ExecutorService tp = Executors.newCachedThreadPool();
    public static Map<Socket,Long> time_stat = new HashMap<>(10240);

    private void startServer() throws Exception{
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(),8000);
        //InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.socket().bind(isa);

        SelectionKey acceptKey = ssc.register(selector,SelectionKey.OP_ACCEPT);
        while(true){
            selector.select();
            Set readKeys = selector.selectedKeys();
            Iterator i = readKeys.iterator();
            long e = 0;
            while(i.hasNext()){
                SelectionKey sk =(SelectionKey) i.next();
                i.remove();
                if(sk.isAcceptable()){
                    doAccept(sk);
                }
                else if(sk.isValid()&&sk.isReadable()){
                    if(!time_stat.containsKey(((SocketChannel)sk.channel()).socket()))
                        time_stat.put(((SocketChannel)sk.channel()).socket(),System.currentTimeMillis());
                    doRead(sk);
                }else if(sk.isValid()&&sk.isWritable()){
                    doWrite(sk);
                    e = System.currentTimeMillis();
                    long b = time_stat.remove(((SocketChannel)sk.channel()).socket());
                    System.out.println("spend:" +(e-b)/1000+"s");
                }
            }
        }
    }

    private void doAccept(SelectionKey sk){
        ServerSocketChannel server = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel;
        try{
            clientChannel = server.accept();
            clientChannel.configureBlocking(false);
            SelectionKey clientKey = clientChannel.register(selector,SelectionKey.OP_READ);
            EchoClient echoClient = new EchoClient();
            clientKey.attach(echoClient);

            InetAddress inetAddress = clientChannel.socket().getInetAddress();
            System.out.println(inetAddress.getHostAddress());
        }catch (IOException e){
            System.out.println("fail");
            e.printStackTrace();
        }
    }

    private void doRead(SelectionKey sk) {
        SocketChannel clientChannel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;
        try{
            len = clientChannel.read(bb);
            if(len<0){
                clientChannel.close();
                return;
            }
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        bb.flip();
        tp.execute(new HandleMsg(sk,bb));
    }

    private void doWrite(SelectionKey sk){
        SocketChannel channel = (SocketChannel) sk.channel();
        EchoClient echoClient = (EchoClient) sk.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutPutQueue();
        ByteBuffer bb = outq.getLast();
        try{
            int len = channel.write(bb);
            if(len == -1){
                channel.close();
                return;
            }
            if(bb.remaining() == 0){
                outq.removeLast();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
        if(outq.size()==0){
            sk.interestOps(SelectionKey.OP_READ);
        }
    }
    class EchoClient{
        private LinkedList<ByteBuffer> outq;
        EchoClient(){
            outq = new LinkedList<ByteBuffer>();
        }
        public LinkedList<ByteBuffer> getOutPutQueue(){
            return outq;
        }
        public void enqueue(ByteBuffer bb){
            outq.addFirst(bb);
        }
    }
    public class HandleMsg implements Runnable {
        SelectionKey key;
        ByteBuffer bb;
        public HandleMsg(SelectionKey key, ByteBuffer bb){
            this.key = key;
            this.bb = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) key.attachment();
            echoClient.enqueue(bb);
            key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }
}

