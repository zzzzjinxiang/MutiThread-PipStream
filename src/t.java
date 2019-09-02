public class t {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        int len = ex1.length;
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
}
