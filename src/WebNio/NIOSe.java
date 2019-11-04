package WebNio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOSe {
    private Selector selector;
    private ExecutorService tp = Executors.newCachedThreadPool();

    public static Map<Socket,Long> map = new HashMap<>();

    private void startServer() throws Exception {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        InetSocketAddress iadrr = new InetSocketAddress(InetAddress.getLocalHost(),8000);
//        InetSocketAddress iadrr = new InetSocketAddress(8000);
        ssc.socket().bind(iadrr);

        SelectionKey acceptKey = ssc.register(selector,SelectionKey.OP_ACCEPT);
        while(true) {
            selector.select();
            Set readKeys = selector.selectedKeys();
            Iterator i = readKeys.iterator();
            long e = 0;
            while(i.hasNext()) {
                SelectionKey sk = (SelectionKey) i.next();
                i.remove();

                if(sk.isAcceptable()) {
                    doRead();
                }
            }
        }
    }

    public void doRead(){

    }

}
