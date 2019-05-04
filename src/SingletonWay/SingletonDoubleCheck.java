package SingletonWay;

public class SingletonDoubleCheck {
    private static volatile SingletonDoubleCheck singletonDoubleCheck;
    private SingletonDoubleCheck(){}
    public static SingletonDoubleCheck getInstance(){
        if (singletonDoubleCheck==null){
            synchronized (SingletonDoubleCheck.class){
                if (singletonDoubleCheck==null)
                    singletonDoubleCheck = new SingletonDoubleCheck();
            }
        }
        return singletonDoubleCheck;
    }
}
