package ProductAndCusumer;

import java.util.concurrent.BlockingQueue;

public class BlockingConsumer implements Runnable {
    private final BlockingQueue blockingConsumer;
    public BlockingConsumer(BlockingQueue blockingConsumer){
        this.blockingConsumer = blockingConsumer;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try{
                System.out.println("消费苹果:"+blockingConsumer.take());
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
