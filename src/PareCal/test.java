package PareCal;

public class test {
    public static void main(String[] args){
        new Thread(new Plus()).start();
        new Thread(new Mutiply()).start();
        new Thread(new Div()).start();

        for(int i=1;i<=1000;i++){
            for(int j=1;j<=1000;j++){
                msg msg = new msg();
                msg.i = i;
                msg.j = j;
                msg.ordstr = "(("+i+"+"+j+")*"+i+")/2";
                Plus.bq.add(msg);
            }
        }
    }
}
