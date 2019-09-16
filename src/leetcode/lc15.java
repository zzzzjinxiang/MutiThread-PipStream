package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        int len = ex1.length;
        int[] tmp = {0,0,0,0};
        List<List<Integer>> list = threeSum(tmp);
        quickSorted(ex1,0,ex1.length-1);
        for(int x : ex1) {
            System.out.println(x);
        }
    }

    public static void quickSorted(int[] nums, int s, int e) {

        if(s < e) {
            int l = s;
            int h = e;
            int tmp = nums[s];
            while(s<e && nums[e]>tmp) {
                e--;
            }
            if(s<e)
                nums[s++] = nums[e];
            while(s<e && nums[s]<tmp) {
                s++;
            }
            if(s<e)
                nums[e--] = nums[s];
            nums[s] = tmp;
            quickSorted(nums,l,s-1);
            quickSorted(nums,s+1,h);
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)
                return res;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int tmp = -nums[i];
            int k = len - 1;
            for(int j = i + 1;j < k;) {
                int lval = nums[j];
                int rval = nums[k];
                if(lval + rval > tmp)
                    k--;
                else if(lval + rval < tmp)
                    j++;
                else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(j < k && nums[j] == lval) j++;
                    while(j < k && nums[k] == rval) k--;
                }
            }
        }
        return res;
    }
}
