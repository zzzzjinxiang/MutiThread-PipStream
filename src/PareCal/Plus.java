package PareCal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Plus implements Runnable {
    public static BlockingQueue<msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while(true){
            try{
                msg msg = bq.take();
                msg.j = msg.i+msg.j;
                Mutiply.bq.add(msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
