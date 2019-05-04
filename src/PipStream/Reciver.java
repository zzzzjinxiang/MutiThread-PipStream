package PipStream;

import java.io.IOException;
import java.io.PipedInputStream;

@SuppressWarnings("all")
public class Reciver extends Thread{

    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getInstance(){
        return in;
    }

    @Override
    public void run(){
        //readMessageOnceTime();
        readMessageConti();
    }

    public void readMessageOnceTime(){
        byte[] by = new byte[2048];
        try{
            int len = in.read(by);
            System.out.println(new String(by,0,len-1));
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readMessageConti(){
        int total=0;
        while(true){
            byte[] bt = new byte[1024];
            try{
                int len = in.read(bt);
                total+=len;
                System.out.println(new String(bt,0,len));
                if(total>1024)
                    break;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            in.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
