package jianzhioffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class mapTest {

    static Map<Character,Integer> map2 = new LinkedHashMap<>();
    static String testStr = "zowslgcjpzs";
    static char[] bts = testStr.toCharArray();

    public static void main(String[] args) {
        f3();
//        Insert();
//        System.out.println(map2.keySet());
//        for (char x : bts){
//            if(map2.get(x)==1) {
//                System.out.println(x);
//                break;
//            }
//        }
    }

    public static void Insert() {
        for(char x : bts) {
            if (map2.containsKey(x))
                map2.put(x, map2.get(x)+1);
            else map2.put(x, 1);
        }
        System.out.println("ok");
    }

    public static void f2() {
        int[] word = new int[58];
        for(int i = 0; i < testStr.length(); i++) {
            word[(int)bts[i]-65] += 1;
        }

        for (int x : word){
            if(x==1)
                System.out.println(x);
        }
    }

    public static void f3(){
        int[] word = new int[58];
        for(int i = 0; i < testStr.length(); i++){
            word[(int)testStr.charAt(i)-65] += 1;
        }

        for (int i = 0; i < word.length; i++){
            if(word[i] == 1)
                System.out.println(i);
        }
        System.out.println("-1");
    }
}
