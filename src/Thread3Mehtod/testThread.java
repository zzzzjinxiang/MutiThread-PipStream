package Thread3Mehtod;

import java.util.HashMap;
import java.util.Map;

public class testThread {

    public static void main(String[] args){
        myThread1 t1 = new myThread1(1);
        myThread2 t2 = new myThread2(2);
        myThread3 t3 = new myThread3(3);

    }

    public static class myThread1 extends Thread {
        private int n = 0;
        private int id;


        public myThread1(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                if (n % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "" + id + "" + n);
                } else {

                }
            }
        }
    }

    public static class myThread2 extends Thread{
        private int n = 0;
        private int id;
        public myThread2(int id){
            this.id = id;
        }
        @Override
        public void run() {
            while(true){
                if(n%2==0)
                    System.out.println(Thread.currentThread().getName()+""+id+""+n);
            }
        }
    }

    public static class myThread3 extends Thread{
        private int n = 0;
        private int id;
        public myThread3(int id){
            this.id = id;
        }
        @Override
        public void run() {
            while(true){
                if(n%3==0)
                    System.out.println(Thread.currentThread().getName()+""+id+""+n);
            }
        }
    }
}
