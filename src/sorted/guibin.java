package sorted;

public class guibin {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        merge_down(ex1,0,ex1.length - 1);
        for(int x:ex1) {
            System.out.print(x + " ");
        }
    }


    public static void merge(int[] nums, int s, int m, int e) {
        int[] tmp = new int[e-s+1];
        int k = 0;
        int start = s;
        int mid = m + 1;
        while(start <= m && mid <= e) {
            if (nums[start] <= nums[mid])
                tmp[k++] = nums[start++];
            else
                tmp[k++] = nums[mid++];
        }
        while(start <= m)
            tmp[k++] = nums[start++];
        while(mid <= e)
            tmp[k++] = nums[mid++];
        for(int i = 0; i < k; i++) {
            nums[s + i] = tmp[i];
        }
    }

    public static void merge_down(int[] nums, int start, int end) {
        if(start >= end || nums == null)
            return;

        int mid = (start + end)/2;
        merge_down(nums,start,mid);
        merge_down(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
}
