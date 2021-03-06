package printInOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private AtomicInteger sycValue = new AtomicInteger(0);

    private static final int MAX_SYC_VALUE = 100;

    public static void main(String[] args) {
        AtomicIntegerExample example = new AtomicIntegerExample();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new RunnableA());
        service.execute(example.new RunnableB());
        service.execute(example.new RunnableC());

        service.shutdown();
    }

    private class RunnableA implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 0) {
                    System.out.println(String.format("第%d遍",
                            sycValue.get() / 3 + 1));
                    System.out.println("A : "+sycValue.get());
                    sycValue.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 1) {
                    System.out.println("B : "+sycValue.get());
                    sycValue.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 2) {
                    System.out.println("C : "+sycValue.get());
                    System.out.println();
                    sycValue.getAndIncrement();
                }
            }

        }
    }
}
