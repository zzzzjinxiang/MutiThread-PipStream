package mianshi.tencent;

import java.util.Scanner;

public class voidDate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] tmp = s.split(" ");
        long y = Long.parseLong(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int d = Integer.parseInt(tmp[2]);
        int dMax = 31;
        if(m == 2) {
            if(runNian(y)) {
                dMax = 29;
            } else dMax = 28;
        } else if(m == 4 || m == 6 || m == 9 || m == 11)
            dMax = 30;
        else dMax = 31;
        System.out.println(f(y, m, d, dMax));
    }

    public static String f(long y, int m, int d, int dMax) {
        if(d > dMax)
            d = d - dMax;
        String mon = m + "";
        String day = d + "";
        String year = y + "";
        if (mon.length() == 1)
            mon = 0 + "" + m;
        if (day.length() == 1)
            day = 0 + "" + d;
        int len = 4 - year.length();
        for(int i = 0; i < len; i++) {
            year = "0" + year;
        }
        return year+"-"+mon+"-"+day;
    }

    public static boolean runNian(long y) {
        if(y > 3200 && y > 172800) {
            if (y % 3200 == 0 && y % 172800 == 0)
                return true;
        }
        else if(y % 100 == 0) {
                if(y % 400 == 0)
                    return true;
            }
        else if(y % 4 == 0) {
            return true;
        }
        return false;
    }

}
