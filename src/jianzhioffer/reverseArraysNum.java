package jianzhioffer;

public class reverseArraysNum {
    public static void main(String[] args) {
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println("a length:" + a.length + "+ res: " + InversePairs(a));
    }
    static int cnt = 0;
    public static int InversePairs(int [] array) {
        int end = array.length - 1;
        f(array, 0, end);
        return cnt;
    }

    public static void f(int[] array, int s, int e) {
        if(s >= e)
            return;
        int mid = (e+s)/2;
        System.out.println("cur len:" + mid);
        f(array, s, mid);
        f(array, mid+1, e);
        cnt(array, s, mid, e);
    }

    public static void cnt(int[] array, int s, int m, int e) {
        int[] tmp = new int[e-s+1];
        int k = 0;
        int start = s;
        int mid = m + 1;
        while(start <= m && mid <= e) {
            if(array[start] < array[mid]){
                tmp[k++] = array[start++];
            }
            else {
                tmp[k++] = array[mid++];
                cnt = (cnt+m-start+1)%1000000007;
            }
        }

        while(start <= m) {
            tmp[k++] = array[start++];
        }

        while(mid <= e) {
            tmp[k++] = array[mid++];
        }

        for(k = 0; k < tmp.length; k++) {
            array[k + s] = tmp[k];
        }
    }
}
