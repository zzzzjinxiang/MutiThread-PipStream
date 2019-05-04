package SingletonWay;

public class SingletonSingleLock {
    private static SingletonSingleLock instance = null;
    private SingletonSingleLock(){}
    public static synchronized SingletonSingleLock getInstance(){
        if(instance==null) {
            instance = new SingletonSingleLock();
        }
        return instance;
    }
}
