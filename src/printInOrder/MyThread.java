package printInOrder;

public class MyThread extends Thread {

    private String name;
    private int count =6;
    public MyThread(String name){
        this.setName(name);
    }

    @Override
    public void run(){
        while(count>=0){
            synchronized (this) {
                try{
                    if(Thread.currentThread().getName().equals("Thread"+String.valueOf(count%3))){
                        count--;
                        System.out.println(Thread.currentThread().getName()+count);
                        Thread.currentThread().wait();
                    }else notifyAll();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        new MyThread("Thread0").start();
        new MyThread("Thread1").start();
        new MyThread("Thread2").start();
    }

}
