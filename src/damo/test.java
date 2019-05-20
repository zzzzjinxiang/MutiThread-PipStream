package damo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args){
        damon1 t1 = new damon1(0);
        damon1 t2 = new damon1(1);
        damon1 t3 = new damon1(2);
        ExecutorService exc = Executors.newFixedThreadPool(3);
        exc.submit(t1);
        exc.submit(t2);
        exc.submit(t3);
        exc.shutdown();
    }

}
