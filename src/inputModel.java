import java.util.Scanner;

public class inputModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = sc.nextLine().split(" ");
        int[] tmp = new int[str.length];
        for(int i = 0; i< str.length; i++) {
            tmp[i] = Integer.parseInt(str[i]);
        }
        int line = sc.nextInt();
        int[][] mat = new int[line][line];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
}
