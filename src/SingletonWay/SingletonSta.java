package SingletonWay;

public class SingletonSta {
    private SingletonSta(){}
    private static class getInstance{
        private static final SingletonSta instance = new SingletonSta();
    }
    private static SingletonSta Instance(){
        return getInstance.instance;
    }
}
