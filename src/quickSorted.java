public class quickSorted {
    public static void quickSort(int[] a,int l,int r){
        if(l<r){
            int left=l;
            int right=r;
            int x = a[l];
            while(left<right){
                while(left<right && a[right]>x)
                    right--;
                if(left<right)
                    a[left++]=a[right];
                while(left<right && a[left]<x)
                    left++;
                if(left<right)
                    a[right--]=a[left];
            }
            a[left]=x;
            quickSort(a,l,left-1);
            quickSort(a,left+1,r);
        }
    }
    public static void main(String[] args) {
         int i;
         int a[] = {20,10,40,60,30,50};
         System.out.printf("before sort:");
         for (i=0; i<a.length; i++)
                 System.out.printf("%d ", a[i]);
         System.out.printf("\n");
         quickSort(a, 0, a.length-1);
         System.out.printf("after  sort:");
         for (i=0; i<a.length; i++)
                 System.out.printf("%d ", a[i]);
         System.out.printf("\n");
     }
}
