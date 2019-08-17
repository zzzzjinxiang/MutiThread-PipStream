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
        int[] tmp = new int[e-s];
        int k = 0;
        int mid = m;
        if(nums[s] < nums[m])
            tmp[k++] = nums[s++];
        if(nums[s] > nums[m])
            tmp[k++] = nums[m++];
        while(s < mid)
            tmp[k++] = nums[s++];
        while(m < e)
            tmp[k++] = nums[m++];
        for(k = 0; k < e; k++) {
            nums[s++] = tmp[k];
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
