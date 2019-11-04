package mianshi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class sortAndSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] res = in.split("],");
        String s1 = in.substring(1,3);
        int val = Integer.valueOf(in.substring(in.length()-1));
        String s = res.toString().substring(1,res.length-2);

        int[] num = {43,23,61,24,32};
        int k = 32;
        quick(0,num.length-1,num);
        System.out.println(searchHand(num,k));
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


    public static int searchHand(int[] num, int k) {
        int s = 0;
        int e = num.length - 1;
        while(s < e) {
            int mid = (e-s)/2+s;
            if(num[mid]  == k) {
                return mid;
            }
            else if(num[mid] < k) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
