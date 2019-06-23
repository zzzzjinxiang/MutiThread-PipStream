package PareCal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Mutiply implements Runnable {
    public static BlockingQueue<msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while(true)
        {
            try{
                msg msg = bq.take();
                msg.i = msg.i*msg.j;
                Div.bq.add(msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
