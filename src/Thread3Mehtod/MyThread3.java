package Thread3Mehtod;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception{
        int sum = 0;
        for(int i=0;i<1000;i++){
            sum+=i;
        }
        return sum;
    }
}
