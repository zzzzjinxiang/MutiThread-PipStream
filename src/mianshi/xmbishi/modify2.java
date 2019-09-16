package mianshi.xmbishi;

public class modify2 {
    public void ver(String[] in) {
        int[][] nums = new int[in.length][in[0].split(" ").length];
        int j = 0;
        for(String x:in) {
            String[] tmp = x.split(" ");
            for(int i = 0; i < nums.length; i++) {
                nums[j][i] = Integer.parseInt(tmp[i]);
            }
            j++;
        }
    }

}
