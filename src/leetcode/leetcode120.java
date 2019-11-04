package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode120 {
    public static void main(String[] args) {
        String s = "232";
        System.out.println(Integer.parseInt(s));
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> n1 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> n2 = new ArrayList<>(Arrays.asList(3,4));
        ArrayList<Integer> n3 = new ArrayList<>(Arrays.asList(6,5,7));
        ArrayList<Integer> n4 = new ArrayList<>(Arrays.asList(4,1,8,3));
        triangle.add(n1);
        triangle.add(n2);
        triangle.add(n3);
        triangle.add(n4);
        int res = minimumTotal(triangle);
        System.out.println(res);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[len-1][i] = triangle.get(len-1).get(i);
        }
        String s = "";
        for(int i = len-2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] += Math.min(dp[i+1][j]+triangle.get(i+1).get(j),
                        dp[i+1][j+1]+triangle.get(i+1).get(j+1));
            }
        }
        return dp[0][0];
    }
}
