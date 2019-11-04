package sorted;

public class maopao {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        int len = ex1.length;
        f(ex1);
        for(int x : ex1) {
            System.out.println(x);
        }
    }

    public static void f(int[] nums) {
        int n = nums.length;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]) {
                    swap(i,j,nums);
                }
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
