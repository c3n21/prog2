import java.util.Scanner;

public class DisegnaRombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int D = 2*N + 1; //righe
        int star = 0;


        for (int i = 1; i <= (D/2) + 1; i++, star += 2) {
            int whitespace = (D/2) + 1 - i;
            System.out.print(" ".repeat(whitespace));
            System.out.println("*" + "*".repeat(star));
        }

        star -= 4;

        for (int i = (D/2); i > 0; i--, star -= 2) {
            int whitespace = (D/2) + 1 - i;
            System.out.print(" ".repeat(whitespace));
            System.out.println("*" + "*".repeat(star));
        }
        
        scanner.close();
    }
}