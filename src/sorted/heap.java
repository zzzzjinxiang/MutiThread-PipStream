package sorted;

public class heap {

    public static void main(String[] args) {
        int[] ex1 = {6,44,36,87,53,46,78,5,13};
        int len = ex1.length;
        heapSort(ex1,len);
        for(int x : ex1) {
            System.out.println(x);
        }
    }
    public static void heapfiy(int[] des, int idx, int len) {
        if(idx >= len)
            return;

        int max = idx;
        int lc = 2*idx+1;
        int rc = 2*idx+2;

        if(lc < len && des[max] < des[lc])
            max = lc;
        if(rc < len && des[max] < des[rc])
            max = rc;
        if(idx != max) {
            swap(des,idx,max);
            heapfiy(des,max,len);
        }
    }

    public static void buildHeap(int[] des, int len) {
        int endNode = len - 1;
        int parent = (endNode-1)/2;
        for(int i = parent; i >= 0; i--) {
            heapfiy(des,i,len);
        }
    }

    public static void heapSort(int[] des, int len) {
        buildHeap(des,len);
        for(int i = len - 1; i >= 0; i--) {
            swap(des,0,i);
            heapfiy(des,0,i);
        }
    }

    public static void swap(int[] nums, int src, int des) {
        int tmp = nums[des];
        nums[des] = nums[src];
        nums[src] = tmp;
    }
}
