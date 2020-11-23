import java.util.Scanner;

public class Soluzione {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if( n <= 6 ) {
            n = 3;
        } else if( n >= 7 && n <= 11 ) {
            n = 7;
        } else if( n >= 12 && n <= 15 ) {
            n = 12;
        } else if( n >= 16 && n <= 17 ) {
            n = 16;
        } else {
            n = 18;
        }

        System.out.println("fascia " + n);
    }
}