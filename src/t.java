public class t {
    public interface a{
        void f();
    }

    public class b implements a{
        @Override
        public void f() {
            double s = 1.2312312312;
            System.out.println("b.f()");
            System.out.println(s);
        }

    }
    public static void main(String[] args){
        int i = 0;
        i=i++;
    }
}
