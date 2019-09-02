import java.util.Scanner;

public class inputModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int[][] mat = new int[line][line];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
}
