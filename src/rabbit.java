import java.util.Scanner;

public class rabbit {
    static String getIndexAndLongest(String users, int n) {
        int res1 = happyMan(users);
        int res2 = maxGroup(users, n);
        return res1 + " " + res2;
    }
    static int maxGroup(String str, int n) {
        int cnt; // 记录
        int res = 0;
        String users = str + str + str;
        for(int i = str.length(); i < users.length(); i ++) {
            if(users.charAt(i) == 'b') {
                if(i > 0 && users.charAt(i - 1) == 'b') continue;
                int j = i + 1;
                cnt = 0;
                while(j - i <= str.length() - 1 && j < users.length() && cnt < n) {
                    if(users.charAt(j) == 'g') cnt ++;
                    j ++;
                }
                while(j - i <= str.length() - 1 && j < users.length() && users.charAt(j) == 'b') {
                    j ++;
                }
                if(j - i > res) res = j - i;
            }
        }
        return res - n;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int n = 0;
        try {
            _users = in.nextLine();
            n = in.nextInt();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users, n);
        System.out.println(res);
    }

    public static int happyMan2(String str) {
        String users = str + str + str;
        int[] nums = new int[users.length()];
        int max = 0;
        int index = 0;
        for(int i = str.length(); i < users.length() - str.length(); i++) {
            if(users.charAt(i) == 'g')
                continue;
            else {
                int j = i - 1;
                while(j >= 0 && users.charAt(j) == 'g' && i - j >str.length()) {
                    nums[i]++;
                    j--;
                }
                j = i + 1;
                while(j < users.length() && users.charAt(j) == 'g' && j - i < str.length()) {
                    nums[i]++;
                    j++;
                }
            }
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index % str.length();
    }

    static int happyMan(String str) {
        String users = str + str + str;
        int[] nums = new int[users.length()];
        int max = 0;
        int index = -1;
        for(int i = str.length(); i < users.length() - str.length(); i++) {
            char c = users.charAt(i);
            if(c == 'g') continue;
            else {
                int j = i - 1;
                while(j >= 0 && i - j <= str.length() - 1 && users.charAt(j) == 'g') {
                    nums[i]++;
                    j --;
                }
                j = i + 1;
                while(j < users.length() && j - i + 1 <= str.length() && users.charAt(j) == 'g') {
                    nums[i] ++;
                    j ++;
                }
                if(nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }
        }
        return index % str.length();
    }
}
