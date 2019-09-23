package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class matrix {
    public static void main(String[] args) {
        int[][] tri = {{1,2,3},{3,4,5},{5,6,7},{2,3,4}};
        f(tri);
        System.out.println(tri.length+" "+tri[0].length);
    }

    public static ArrayList<Integer> f(int[][] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i< num.length; i++) {
            list.add(new ArrayList(Arrays.asList(num[i])));
        }
        while(!list.isEmpty()) {
            tmp = list.remove(0);
        }
        for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num[i].length; j++) {

            }
        }
        return null;
    }
}
