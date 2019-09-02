package sorted;

public class quicksort {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        int len = ex1.length;
        quick(0,ex1.length-1,ex1);
        for(int x : ex1) {
            System.out.println(x);
        }
    }

    public static void quick(int start, int end, int[] num){
        if(start<end) {
            int s = start;
            int e = end;
            int target = num[s];
            while(s < e){
                while(s < e && target < num[e])
                    e--;
                if(s < e)
                    num[s++] = num[e];
                while(s < e && target > num[s])
                    s++;
                if(s < e)
                    num[e--] = num[s];
            }
            num[s] = target;
            quick(start, s - 1, num);
            quick(s + 1, end, num);
        }
    }
}
