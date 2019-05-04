package SingletonWay;

public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return instance;
    }
}
