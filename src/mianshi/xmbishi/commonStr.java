package mianshi.xmbishi;
import java.util.*;

public class commonStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        System.out.println(f(s1, s2));

    }
    public static int f(char[] s1, char[] s2) {
        int l1 = s1.length;
        int l2 = s2.length;
        int[][] dp = new int[l1+1][l2+1];
        int max = 0;
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(s1[i-1] == s2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
