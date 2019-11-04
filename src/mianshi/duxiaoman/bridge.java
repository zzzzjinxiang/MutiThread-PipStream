package mianshi.duxiaoman;


import java.util.Scanner;

public class bridge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        int[] scale = new int[2];
        String[] sca = n.split(" ");
            for(int i = 0; i < 2; i++) {
            scale[i] = Integer.parseInt(sca[i]);
        }
        String[] W = in.nextLine().split(" ");
        String[] T = in.nextLine().split(" ");
        int[] w = new int[scale[0]];
        int[] t = new int[scale[0]];
        for(int i = 0; i < W.length; i++) {
            w[i] = Integer.parseInt(W[i]);
            t[i] = Integer.parseInt(T[i]);
        }
        System.out.println();
    }
}
