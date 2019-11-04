package fairLock;

import java.util.concurrent.locks.ReentrantLock;

public class fairLock extends Thread {
    public static ReentrantLock lock = new ReentrantLock(true);
    int i = 0;
    @Override
    public void run() {
        while(i<100){
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+ "-" + i++);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        fairLock r1 = new fairLock();
        Thread t1 = new Thread(r1,"thread1");
        Thread t2 = new Thread(r1,"thread2");
        Thread t3 = new Thread(r1,"thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
