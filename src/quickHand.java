import java.util.Stack;

public class quickHand {

    public static void main(String[] args) {
        int a = 16;
        Stack<Integer> s = new Stack<>();
        s.push(a);
        System.out.println(f(a,s));
    }
    public static boolean f(int a, Stack<Integer> s) {
        int times = 0;
        while(times < 10) {
            int tmp = s.pop();
            int len = get(tmp);
            int cur = cal(devide(tmp, len));
            s.push(cur);
            if(cur == 1) {
                return true;
            }
            times++;
        }
        return false;
    }
    public static int cal(int[] a) {
        int res = 0;
        for(int i = 0; i < a.length; i++)
            a[i] = a[i]*a[i];
        for(int i = 0; i < a.length; i++)
            res += a[i];
        return res;

    }

    public static int get(int a) {
        int t = 0;
        while(a>0) {
            a /= 10;
            t++;
        }
        return t;
    }

    public static int[] devide(int a, int len) {
        int e = a;
        int t = 0;
        int[] b = new int[len];
        String str = "asdsa";
        while(a>0) {
            e = a%10;
            a /= 10;
            b[t++] = e;
        }
        return b;
    }

}
