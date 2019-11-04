package leetcode;

public class lc134 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int j = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++) {
            index = i;
            int pre = cost[i];
            int cur = gas[i];
            int cnt = 0;
            for(j = (i+1)%gas.length; j < gas.length ;) {
                int tmp = cur - pre;
                if(tmp < 0)
                    break;
                cur = tmp + gas[j];
                if(cnt == 1 && j == i)
                    return index;
                pre = cost[j];
                if(j == gas.length - 1) {
                    cnt++;
                    j = (j+1)%gas.length;
                }
                else j++;
            }
        }
        return -1;
    }
}
