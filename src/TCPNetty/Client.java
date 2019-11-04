package TCPNetty;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        Socket clientSocket = new Socket();
        try {
            clientSocket.connect(new InetSocketAddress(8081));
            new sendThread(clientSocket).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class sendThread extends Thread{
        private Socket socket;
        PrintWriter printWriter = null;
        public sendThread(Socket socket){
            this.socket = socket;
            try {
                printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void sendPacket(String message){
            try{
                OutputStream writer = socket.getOutputStream();
                writer.write(message.getBytes());
                writer.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String reqMessage = "TCP leetcode.jianzhi full";
            for(int i =0;i<100;i++){
                sendPacket(reqMessage);
            }
            if(socket!=null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

}
