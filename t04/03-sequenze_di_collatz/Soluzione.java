import java.util.Scanner;

public class Soluzione {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;

        for(; n > 1; i++) {
            System.out.print(n + " ");
            if(n % 2 == 0) {
                n = n>>1;
            } else {
                n *= 3;
                n++;
            }
        }

        System.out.println(n + " " + i);

        scanner.close();
    }
}