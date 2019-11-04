package TCPNetty;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8081));
            while(true){
                Socket socket = serverSocket.accept();
                new ReceiverThread(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class ReceiverThread extends Thread{
        public static final int PACKET_HEAD_LENGTH = 2;
        private Socket socket;
        private volatile byte[] bytes = new byte[0];

        public ReceiverThread(Socket socket){
            this.socket = socket;
        }

        public byte[] mergeByte(byte[] a,byte[] b,int begin,int end){
            byte[] add = new byte[a.length+end-begin];
            int i = 0;
            for(;i<a.length;i++){
                add[i] = a[i];
            }
            for(int k=begin;k<end;k++,i++){
                add[i] = b[k];
            }
            return add;
        }

        @Override
        public void run() {
            int count = 0;
            while(true){
                try{
                    InputStream reader = socket.getInputStream();
                    //组装head
                    if(bytes.length<PACKET_HEAD_LENGTH){
                        byte[] head = new byte[PACKET_HEAD_LENGTH-bytes.length];
                        int counter = reader.read(head);
                        if(counter<0){
                            continue;
                        }
                        bytes = mergeByte(bytes,head,0,counter);
                        if(counter>PACKET_HEAD_LENGTH){
                            continue;
                        }
                    }
                    byte[] temp = new byte[0];
                    temp = mergeByte(temp,bytes,0,PACKET_HEAD_LENGTH);
                    String tempLength = new String(temp);
                    int bodyLength = Integer.parseInt(tempLength);
                    //组装body
                    if(bytes.length-PACKET_HEAD_LENGTH<bodyLength){
                        byte[] body = new byte[bodyLength+PACKET_HEAD_LENGTH-bytes.length];
                        int counter = reader.read(body);
                        if(counter<0)
                            continue;
                        bytes = mergeByte(bytes,body,0,counter);
                        if(counter<body.length)
                            continue;
                    }
                    byte[] body = new byte[0];
                    body = mergeByte(body,bytes,PACKET_HEAD_LENGTH,bytes.length);
                    count ++;
                    System.out.println("Server receive body:" + count +new String(body));
                    bytes = new byte[0];
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
