package printInOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoresExample {

    private Semaphore semaphoresA = new Semaphore(1);
    private Semaphore semaphoresB = new Semaphore(0);
    private Semaphore semaphoresC = new Semaphore(0);

    public static void main(String[] args) {
        SemaphoresExample example = new SemaphoresExample();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new RunnableA());
        service.execute(example.new RunnableB());
        service.execute(example.new RunnableC());

        service.shutdown();
    }

    private class RunnableA implements Runnable {

        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    semaphoresA.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(String.format("第%d遍", i + 1));
                System.out.println("A");
                semaphoresB.release();

            }
        }
    }

    private class RunnableB implements Runnable {

        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    semaphoresB.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("B");
                semaphoresC.release();
            }

        }
    }

    private class RunnableC implements Runnable {

        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    semaphoresC.acquire();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("C");
                System.out.println();

                semaphoresA.release();
            }
        }
    }
}
