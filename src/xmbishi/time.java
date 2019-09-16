package xmbishi;

import java.util.Stack;

public class time {
    static int solution(int[] arr) {
        int N = arr.length;
        int ans1 = 0;
        int ans2 = 0;
        int[] arr1 = arr;
        int[] arr2 = arr;

        for(int i=1;i<N;++i){
            if(arr1[i]<arr1[i-1]){
                ++ans1;
                int j = i;
                while(j>=1&&arr1[j]<arr1[j-1]){
                    swap(arr1,j,j-1);
                    j--;
                }
            }
        }

        for(int i=1;i<N;++i){
            if(arr2[i]>arr2[i-1]){
                ++ans2;
                int j = i;
                while(j>=1&&arr2[j]>arr2[j-1]){
                    swap(arr2,j,j-1);
                    j--;
                }
                int[] a = {1,2};
                Stack<Integer> s = new Stack<>();
            }
        }
        return Math.min(ans1,ans2);
    }

    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
