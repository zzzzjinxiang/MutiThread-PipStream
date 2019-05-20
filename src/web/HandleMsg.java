package web;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HandleMsg{
    private Selector selector;
    private Map<Socket,Long> map;
    public void stat() throws Exception{
        /**
         * 创建selector 实例(静态工厂provider())->创建服务器channel->设置监听地址及端口(InetSocketAddress)
         * ->将channel与selector绑定SelectionKey(channel.register())->channel监听指定地址(InetSocketAddress)
         */
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open() ;
        ssc.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(),8080);
        SelectionKey key = ssc.register(selector,SelectionKey.OP_ACCEPT);
        ssc.socket().bind(isa);
        while (true){
            selector.select();//阻塞
            Set readyKeys = selector.selectedKeys();//获取已准备好的channel
            Iterator it = readyKeys.iterator();
            while(it.hasNext()){
                SelectionKey sk = (SelectionKey) it.next();
                it.remove();
                if(sk.isValid()&&sk.isReadable()){
                    if(!map.containsKey(((SocketChannel)sk.channel()).socket()))
                        map.put(((SocketChannel)sk.channel()).socket(),System.currentTimeMillis());
                }
            }
        }
    }
}
