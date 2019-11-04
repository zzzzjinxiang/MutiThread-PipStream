package mianshi.duxiaoman;

import java.util.Scanner;

public class bitCow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        String[] tmp = s.split(" ");
        int[] num = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            num[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println(f(num,n));
    }
    public static int f(int[] tmp, int n) {
        if(n<3)
            return tmp[0]>tmp[1] ? tmp[0] : tmp[1];
        int pre;
        int tail;
        int cnt = 0;
        for(int i = 0; i < n-2;) {
            int tailIdx = 0;
            if(i+2 < n)
                tailIdx = n-1;
            pre = tmp[i];
            tail = tmp[i+2];
            if(pre < tail) {
                cnt += tail;
                if(i+2 < n) {
                    tmp[i+2] -= cnt;
                }
                else tmp[n-(i+2+1)+i+2] -=cnt;
            }
            else {
                cnt += pre;
                tmp[i] -= pre;
            }
            if(i+2+1 == n-1) {
                return cnt+tmp[n-1];
            }
            else if(i+2 == n-2)
                return cnt;
            else
                i += 2;
        }
        return cnt;
    }
}