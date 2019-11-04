package PareSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParaSea {
    public int[] arr;
    public int searchVal;
    public static ExecutorService pool = Executors.newCachedThreadPool();
    public static int Thread_num=4;
    public static AtomicInteger res = new AtomicInteger(-1);
    public ParaSea(int[] arr){
        this.arr = arr;
    }

    public int search(int searchVal,int begin,int end) {
        int i = 0;
        for (i = begin; i < end; i++) {
            if (res.get() >= 0)
                return res.get();
            if (arr[i] == searchVal) {
                if (!res.compareAndSet(-1, i))
                    return res.get();
            }
            return i;
        }
        return -1;
    }
    public class SearchTask implements Callable<Integer> {
        int begin,end,searchVal;
        public SearchTask(int searchVal,int begin,int end){
            this.begin=begin;
            this.end=end;
            this.searchVal=searchVal;
        }
        public Integer call(){
            int res = search(searchVal,begin,end);
            return res;
        }
    }
    public int pSearch(int searchVal) throws InterruptedException, ExecutionException {
        int sub = arr.length/Thread_num+1;
        List<Future<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length;i+=sub){
            int end = i+sub;
            if(end>=arr.length) end = arr.length;
            res.add(pool.submit(new SearchTask(searchVal,i,end)));
        }
        for(Future<Integer> fu:res){
            if(fu.get()>=0)return fu.get();
        }
        return -1;
    }
}

