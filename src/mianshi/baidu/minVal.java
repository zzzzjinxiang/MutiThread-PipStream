package mianshi.baidu;

import java.util.Scanner;

public class minVal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        long k = in.nextInt();
        System.out.println(f(n, m, k));
    }

    public static long f(long n, long m, long k) {
        if((long)n*m <= k)
            return 0;
        if(n > m) {
            long tmp = n;
            n = m;
            m = tmp;
        }
        long res = 0l;
        while((long)(n * m) > k) {
            n--;
            res++;
        }
        return res;
    }
}