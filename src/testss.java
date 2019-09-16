import java.util.*;

public class testss {

    public static void main(String[] args) {
        int num = 7;
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 2, 1, 4, 1, 7));
        terminals(num, list);

    }

    static List<Integer> terminals(int terminalsCount,
                                   List<Integer> terminalsStrength) {
        // WRITE YOUR CODE HERE
        int[] dp = new int[terminalsCount];
        dp[0] = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < terminalsCount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (j + terminalsStrength.get(j) >= i) {
                    min = Math.min(min, j);
                }
                else continue;
            }
            dp[i] = min;
        }
        for (int i = dp.length - 1; i > 0; ) {
            res.add(dp[i]);
            i = dp[i];
        }
        Collections.reverse(res);
        return res;
    }

    int perfectDancers(int countMorning, int countEvening, int[] morningList,
                       int[] eveningList) {
        ArrayList<Integer> morning = new ArrayList<>();
        ArrayList<Integer> evening = new ArrayList<>();
        HashSet<Integer> mset = new HashSet<>();
        HashSet<Integer> eset = new HashSet<>();
        for (int i = 0; i < countMorning; ++i) {
            int m = 0;
            morning.add(morningList[i]);
            mset.add(morningList[i]);
        }
        for (int i = 0; i < countEvening; ++i) {
            int m = 0;
            evening.add(eveningList[i]);
            eset.add(eveningList[i]);
        }
        int ans = 0;
        for (int m : morning) {
            if (eset.contains(m))
                ++ans;
        }
        for (int m : evening) {
            if (mset.contains(m))
                ++ans;
        }
        return ans;
    }
}