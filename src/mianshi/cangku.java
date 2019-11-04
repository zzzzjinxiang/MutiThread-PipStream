package mianshi;

public class cangku {

    public static void main(String[] args) {
        int people = 5;
        int AW = 3;
        int BW = 2;
        int[] A = {13,4,15};
        int[] B = {12,7,8};

    }

    public static int cost(int p, int AW, int BW, int[] A, int[] B) {
        int[][][] dp = new int[p][AW][BW];
        for(int i = 0; i < p; i++) {
            for(int j = 0; j < AW; j ++) {
                for(int k = 0; k < BW; k++) {
                    dp[i][j][k] = Math.min(dp[i][j][k-A[k]] + A[k], dp[i][j][k-1]);
                }
            }
        }
        return 0;
    }
}
