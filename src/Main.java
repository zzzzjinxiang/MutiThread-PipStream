import java.nio.channels.spi.SelectorProvider;

public class Main {
    static class parents{
        public static int A = 1;
        static {
            A = 2;
        }
    }
    static class kid extends parents{
        public static int B = A;
        private volatile int x=0;
    }

    public static void main(String[] args) {
        System.out.println(kid.B);

    }
}
