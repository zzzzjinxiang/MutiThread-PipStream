package mianshi.huawei;

import java.util.Scanner;

public class xiaoli {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int group = Integer.parseInt(in.nextLine());
        for(int i = 0; i < group; i++) {
            String day = in.nextLine();
            String change = in.nextLine();
            int d = Integer.parseInt(day);
            int[] pow = new int[d];
            String[] c = change.split(" ");
            for(int j = 0; j < Integer.parseInt(day); j++) {
                pow[j] = Integer.parseInt(c[j]);
            }
            int dmax = 0;
            int curP = 0;
            for(int j = 0; j < d; j++) {
                int tmp = 0;
                for(int x = 0; x < j; x++) {
                    if(pow[x] < pow[j])
                        tmp++;
                    if(pow[x] > pow[j])
                        tmp--;
                }
                curP += tmp;
                dmax = Math.max(dmax, curP);
            }
            System.out.println(dmax + " " + curP);
        }
    }
}
