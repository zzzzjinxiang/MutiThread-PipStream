package mianshi.baidu;
import java.util.*;

public class returnCom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] ways = new int[m][2];
            for(int j = 0; j < m; j++) {
                ways[j][0] = in.nextInt();
                ways[j][1] = in.nextInt();
                if(ways[j][0] > ways[j][1]) {
                    int tmp = ways[j][0];
                    ways[j][0] = ways[j][1];
                    ways[j][1] = tmp;
                }
            }
            if (f(ways, 2, n, 1, m)) {
                System.out.println("POSSIBLE");
            }
            else System.out.println("IMPOSSIBLE");
        }
    }

    public static boolean f(int[][] mat, int step, int des, int now, int m) {
        if(step == 0 && des == now)
            return true;
        else if(step == 0) return false;
        for (int i = 0; i < m; i++) {
                if(mat[i][0] == now) {
                    if(f(mat, step - 1, des, mat[i][1],m))
                        return true;
                }
        }
        return false;
    }
}
