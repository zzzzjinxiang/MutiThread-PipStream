package PipStream;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class testPiped {
    public static void main(String[] args){
        Sender t1 = new Sender();
        Reciver t2 = new Reciver();
        PipedOutputStream out = t1.getInstance();
        PipedInputStream in = t2.getInstance();
        try{
            in.connect(out);

            t1.start();
            t2.start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
