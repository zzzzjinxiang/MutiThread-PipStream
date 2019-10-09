package mianshi.huawei;

import java.util.Scanner;

public class sales {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] t = line.split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int[] init = new int[n];
        for(int i = 0; i < n; i++) {
            init[i] = in.nextInt();
        }
        String s = in.nextLine();
        for(int i = 0; i < m; i++) {
            String test = in.nextLine();
            String[] tmp = test.split(" ");
            if(tmp[0].equals("Q")) {
                int sum = 0;
                int begin = Integer.parseInt(tmp[1]);
                int end = Integer.parseInt(tmp[2]);
                for(int j = begin - 1; j < end; j++) {
                    sum += init[j];
                }
                System.out.println(sum/(end-begin+1));
            }
            else if(tmp[0].equals("U")) {
                int idx = 0;
                idx = Integer.parseInt(tmp[1]);
                init[idx - 1] += Integer.parseInt(tmp[2]);
            }
        }
    }
}
