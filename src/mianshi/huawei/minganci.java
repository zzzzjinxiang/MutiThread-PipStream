package mianshi.huawei;

import java.util.Scanner;

public class minganci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pro = in.nextLine();
        String[] pro2 = pro.split(" ");
        String tar = pro2[0];
        String par = pro2[1];
        f(tar, par);
    }

    public static void f(String tar, String par) {
        int[] next = new int[par.length()+1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        for(i = 0; i < par.length();) {
            if(j == -1 || tar.charAt(j) == par.charAt(i)) {
                i++;
                j++;
                next[i] = j;
            } else j = next[j];
        }

        for(i = 0, j = 0; i < tar.length() && j < par.length();) {
            if(j == -1 || tar.charAt(i) == par.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }

        int pos = 0;
        if(j == par.length())
            pos = i - j;
        else pos = -1;
        char[] res = tar.toCharArray();
        if(pos >= 0) {
            for(i = pos; i < pos + par.length(); i++) {
                res[i] = '*';
            }
        }
        for(char x:res) {
            System.out.print(x);
        }
    }

}
