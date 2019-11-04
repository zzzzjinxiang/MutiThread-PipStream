package juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class cycBarrier {

    private Lock lock = new ReentrantLock();
    private static StampedLock rwlock = new StampedLock();


    public static class people implements Runnable {
        private CyclicBarrier cyc = new CyclicBarrier(5);

        @Override
        public void run() {
            try {
                cyc.await();
                doSome();
                cyc.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void doSome() throws InterruptedException{
            Thread.sleep(1000);
            System.out.println("done:"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws Exception {
        people te = new people();
        ExecutorService queue = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            queue.submit(te);
        }
        System.out.println("continue");
        queue.shutdown();
    }

}
