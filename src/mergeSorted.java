public class mergeSorted {
    public static void merge(int[] a,int low,int mid,int high){
        int[]tmp = new int[high-low+1];
        int left = low;
        int left2 = mid+1;
        int temp = 0;

        while(low<=mid && left2<=high){
            if(a[left]<=a[left2])
                tmp[temp++] = a[left++];
            else
                tmp[temp++] = a[left2++];
        }

        while(left<=mid)
            tmp[temp++] = a[left++];
        while(left2<=high)
            tmp[temp++] = a[left2];
        for(left=0;left<temp;left++)
            a[low+left]=tmp[left];
    }
    public static void mergeSortUp(int[] a,int start, int end){
        if(a==null || start>=end)
            return;
        int mid=(end+start)/2;
        mergeSortUp(a, start, mid);
        mergeSortUp(a, mid+1, end);
        merge(a, start, mid, end);
    }

    public static void main(String[] args) {
         int i;
         int a[] = {80,30,60,40,20,10,50,70};

         System.out.printf("before sort:");
         for (i=0; i<a.length; i++)
             System.out.printf("%d ", a[i]);
         System.out.printf("\n");

         mergeSortUp(a, 0, a.length-1);        // 归并排序(从上往下)
         //mergeSortDown2Up(a);                    // 归并排序(从下往上)

         System.out.printf("after  sort:");
         for (i=0; i<a.length; i++)
             System.out.printf("%d ", a[i]);
         System.out.printf("\n");
     }
}
