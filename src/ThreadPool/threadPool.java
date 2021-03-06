package ThreadPool;

public class threadPool implements Runnable {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public threadPool(Integer id){
        this.id=id;
    }

    int sum = 0;


    @Override
    public void run() {
        while(sum<100) {
            synchronized (threadPool.class) {
                try {
                    if (sum % 3 == id) {
                        System.out.println(Thread.currentThread().getName() + ":" + sum +" "+id+" "+Thread.currentThread().getId());
                        sum++;
                    }
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            sum++;
        }
    }

}
