package Thread3Mehtod;

import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test {
    public static void main(String[] args){
        new MyThread().start();
        new Thread(new MyThread2()).start();
        FutureTask<Integer> res = new FutureTask<>(new MyThread3());
        new Thread(res).start();
        int sum=0;
        try{
            sum += res.get();
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
