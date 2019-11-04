package ProductAndCusumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class test {
    public static void main(String[] args){
        /*

        Thread thread1 = new Thread(producter);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
*/
        BlockingQueue box = new LinkedBlockingQueue();
        BlockingProductor blockingProductor = new BlockingProductor(box);
        BlockingConsumer blockingConsumer = new BlockingConsumer(box);
        Thread thread1 = new Thread(blockingProductor);
        Thread thread2 = new Thread(blockingConsumer);
        thread1.start();
        thread2.start();
    }
}
