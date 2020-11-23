import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //always int
        scanner.close();

        for(int i = 1; i <= n; i++) {

            if( i % 21 == 0) {

                System.out.println("Tico Taco");

            } else {

                if(i%3 == 0) {

                        System.out.println("Tico");

                } else if(i%7 == 0) {

                    System.out.println("Taco");

                } else {

                    System.out.println(i);

                }
            }
        }
    }
}