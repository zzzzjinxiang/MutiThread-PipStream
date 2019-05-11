package ProductAndCusumer;

import ProductAndCusumer.PublicBox;

public class Consumer implements Runnable {
    private PublicBox box;
    public Consumer(PublicBox box){
        this.box=box;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try
            {
                System.out.println("con:i"+i);
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            box.decrease();
        }
    }
}
