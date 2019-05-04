import ProductAndCusumer.BlockingConsumer;
import ProductAndCusumer.BlockingProductor;
import ProductAndCusumer.PublicBox;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
/*        Thread3Mehtod.MyThread2 myThread2=new Thread3Mehtod.MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        Thread3Mehtod.MyThread3 myThread3 = new Thread3Mehtod.MyThread3();
        FutureTask<Integer> result = new FutureTask<>(myThread3);
        new Thread(result).start();
        try{
            Integer sum = result.get();
            System.out.println(sum);
        }catch (InterruptedException | ExecutionException e ){
            e.printStackTrace();
        }*/
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
