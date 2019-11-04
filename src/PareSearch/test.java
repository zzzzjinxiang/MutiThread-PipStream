package PareSearch;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class test {
    public static void main(String[] args){
        int[] arr = new int[50];
        for(int i=0;i<50;i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        ParaSea sea = new ParaSea(arr);
        try {
            System.out.println(sea.pSearch(42));
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
