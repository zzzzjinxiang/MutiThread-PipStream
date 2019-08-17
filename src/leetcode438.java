import java.util.ArrayList;

public class leetcode438 {

    public static void main(String[] args){
        String s = "baa";
        String p = "aa";
        System.out.println(solution(s,p));
    }

    public static ArrayList<Integer> solution(String s, String p){
        ArrayList<Integer> ret = new ArrayList<>();

        int ls = s.length();
        int lp = p.length();
        // 记录p信息
        int[] to_match = new int[26];
        int com = 0;
        int to_total_match = 0;
        for (int i = 0; i < lp; i++) {
            to_match[p.charAt(i)-'a']++;
        }
        // !=0去重 {"baa"} {"aa"}
        for (int i = 0; i < 26; i++) {
            if(to_match[i] != 0)
                to_total_match++;
        }

        for (int i = 0; i < lp-1; i++) {
            int index = s.charAt(i)-'a';
            to_match[index]--;
            if(to_match[index] == 0) to_total_match--;
            else if(to_match[index]==-1) to_total_match++;
        }

        for (int i = lp - 1; i < ls; i++){
            int high = s.charAt(i)-'a';
            to_match[high]--;
            if(to_match[high] == 0) to_total_match--;
            else if(to_match[high]==-1) to_total_match++;
            if (i - lp >= 0) {
                int low = s.charAt(i-lp)-'a';
                to_match[low]++;
                if (to_match[low]==0) to_total_match--;
                else if (to_match[low]==1) to_total_match++;
            }
            if (to_total_match==0) ret.add(i-lp+1);
        }
        return ret;
    }
}
