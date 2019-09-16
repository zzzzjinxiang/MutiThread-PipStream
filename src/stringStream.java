import java.util.Scanner;

public class stringStream {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        //处理空格
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        s1 = "";
        for(String x:str1) {
            s1 += x;
        }
        s2 = "";
        for(String x:str2) {
            s2 += x;
        }
        String res = helper(s1, s2);
//        System.out.println(res);
        for(int i = 0; i < res.length(); i ++){
            System.out.print(res.charAt(i) + " ");
        }

    }
    public static String helper(String s1, String s2){
        if(s1 == null || s1.length() == 0) return s2;
        if(s2 == null || s2.length() == 0) return s1;
        StringBuilder sb = new StringBuilder();
        int i  = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(i + 4 <= s1.length()) sb.append(s1.substring(i, i + 4));
            else sb.append(s1.substring(i, s1.length()));
            sb.append(s2.charAt(j));
            i += 4;
            j ++;
        }
        if(i >= s1.length()){
            sb.append(s2.substring(j, s2.length()));
        }else if(j >= s2.length()){
            sb.append(s1.substring(i, s1.length()));
        }
        return sb.toString();
    }
}
