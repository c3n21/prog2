import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int spaces = 2*(n-1)-1;

        for(int i = 0; i < n; i++, spaces-=2) {

            System.out.println(" ".repeat(i) + "*" + " ".repeat((spaces < 0? spaces=0 : spaces)) + (spaces >= 1? "*":""));
        }

        scanner.close();
    }
}