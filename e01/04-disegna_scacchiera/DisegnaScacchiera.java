import java.util.Scanner;

public class DisegnaScacchiera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int N = 8;
        final int n = scanner.nextInt();
        scanner.close();

        System.out.print(
            ((("-".repeat(n) + "#".repeat(n)).repeat(N/2) + "\n").repeat(n) + //prima linea della scacchiera
            (("#".repeat(n) + "-".repeat(n)).repeat(N/2) + "\n").repeat(n))/*seconda linea della scacchiera*/
            .repeat(N/2) //stampo tutte e 8 le colonne
        );
    }
}