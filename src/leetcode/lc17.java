package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc17 {

    public static void main(String[] args) {
        String trial = "23";
        System.out.println(letterCombinations(trial));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        return f(digits, map);
    }

    public static List<String> f(String num, HashMap<Integer, String> map) {
        if(num == null || num.length() < 1)
            return new ArrayList<String>();

        List<String> res = new ArrayList<>();

        if(num.length() == 1) {
            String tmp = map.get(Integer.parseInt(num));
            for(int i = 0; i < tmp.length(); i++) {
                res.add("" + tmp.charAt(i));
            }
            return res;
        }

        List<String> pre = f(num.substring(1), map);
        String s = map.get(Integer.parseInt(num.substring(0, 1)));

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < pre.size(); j++) {
                res.add(s.charAt(i) + "" + pre.get(j));
            }
        }
        return res;
    }
}
