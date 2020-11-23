import java.util.Arrays;
import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        int n      = Integer.parseInt(args[0]);
        int m      = Integer.parseInt(args[1]);
        int [][] M = new int[n][m];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            M[i] = new int[m];

            for (int j = 0; j < m; j++) {
                M[i][j] = scanner.nextInt();
            }
        }
         
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(M[j][i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}