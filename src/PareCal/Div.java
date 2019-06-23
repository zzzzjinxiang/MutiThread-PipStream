package PareCal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Div implements Runnable {
    public static BlockingQueue<msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while(true){
            try{
                msg msg = bq.take();
                msg.i = msg.j/2;
                System.out.println(msg.ordstr+"="+msg.i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
