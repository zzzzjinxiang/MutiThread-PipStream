package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args){
        threadPool t1 = new threadPool(0);
        threadPool t2 = new threadPool(1);
        threadPool t3 = new threadPool(2);
        ExecutorService exc = Executors.newFixedThreadPool(3);
        exc.submit(t1);
        exc.submit(t2);
        exc.submit(t3);
        exc.shutdown();
    }

}
