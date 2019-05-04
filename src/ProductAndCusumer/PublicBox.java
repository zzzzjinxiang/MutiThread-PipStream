package ProductAndCusumer;

public class PublicBox {
    private int apple = 0;
    public synchronized void increase(){
        while(apple==5){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        apple++;
        System.out.println("生成成功");
        notify();
    }
    public synchronized void decrease(){
        while(apple==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple--;
        System.out.println("消费成功");
        notify();
    }
}
