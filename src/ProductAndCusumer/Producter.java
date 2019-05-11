package ProductAndCusumer;

import ProductAndCusumer.PublicBox;

public class Producter implements Runnable {
    private PublicBox box ;
    public Producter(PublicBox box){
        this.box=box;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try{
                System.out.println("Pro:i"+i);
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            box.increase();
        }
    }
}
