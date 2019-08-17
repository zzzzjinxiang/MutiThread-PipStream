package sorted;

public class quicksort {

    public static void quick(int start, int end, int[] num){
        if(start>end) {
            int s = start;
            int e = end;
            int target = num[s];
            while(s<e){
                if(target>num[e]) {
                    num[s] = num[e];
                    e--;
                }
                if(target<num[s]){
                    num[e] = num[s];
                    s++;
                }
            }
            int mid = s;
            quick(start, mid - 1, num);
            quick(mid + 1, start, num);
        }
    }
}
