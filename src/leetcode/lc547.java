package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class lc547 {

    public static void main(String[] args) {
        int[][] M = {{1,1,0,1},{1,1,0,1},{0,1,1,0},{1,0,0,1}};
        System.out.println(solutionBFS(M));
        System.out.println();
    }

    public static int solutionBFS(int[][] M) {
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < M.length; i++) {
            if(!set.contains(i)) {
                BFS(queue, set, M, i);
                // 成功BFS则增加一次
                res++;
            }
        }
        return res;
    }

    public static void BFS(LinkedList<Integer> q, Set<Integer> set, int[][] M, int i) {
        q.add(i);
        set.add(i);
        while(!q.isEmpty()) {
            int k = q.removeFirst();
            set.add(k);
            for(int j = 0; j < M[k].length; j++) {
                if(M[k][j] == 1 && !set.contains(j))
                    q.addLast(j);
            }
        }
    }

    public static int solutionDFS(int[][] M) {
        int cnt = 0;
        boolean[] flag = new boolean[M.length];
        for(int i = 0; i < M.length; i++) {
            if(!flag[i]){
                DFS(M, flag, i);
                cnt++;
            }
        }
        return cnt;
    }

    public static void DFS(int[][] M, boolean[] flag, int no) {
        flag[no] = true;
        for(int i = 0; i < M[no].length; i++) {
            if(!flag[i] && M[no][i] == 1)
                DFS(M, flag, i);
        }
    }


}
