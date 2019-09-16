import java.util.Arrays;
import java.util.Scanner;

public class f {

        public static void main(String args[])
        {
            Scanner cin = new Scanner(System.in);
            String line = cin.nextLine();
            String[] res = line.split(" ");
            int[] r = new int[res.length];
            for(int i = 0; i < res.length; i++) {
                r[i] = Integer.parseInt(res[i]);
            }
            System.out.println(getMin(r));
            System.out.println(getAverage(r));
        }

        public static int getMin(int[] n) {
            Arrays.sort(n);
            return n[n.length - 1];
        }
        public static double getAverage(int[] num) {
            int res = 0;
            for(int i = 0; i < num.length; i++) {
                res += num[i];
            }
            double re = Double.valueOf(res);
            return re/num.length;
        }

}
