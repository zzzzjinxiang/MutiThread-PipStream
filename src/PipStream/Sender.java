package PipStream;

import java.io.IOException;
import java.io.PipedOutputStream;

@SuppressWarnings("all")
public class Sender extends Thread {
    private PipedOutputStream out = new PipedOutputStream();
    public PipedOutputStream getInstance(){
        return out;
    }

    @Override
    public void run(){
        //outOnce();
        outContinue();
    }

    public void outOnce(){
        String info = "this is a message";
        try{
            out.write(info.getBytes());
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void outContinue(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<102;i++){
            sb.append("0123456789");
        }
        sb.append("abcdefghijklmnopqrstuvwxyz");
        String s = sb.toString();
        try{
            out.write(s.getBytes());
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
