import java.util.Scanner;

public class ProvaDelNove {
    public static void main(String args[]) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            provaDelNove(n);
        } 
    }

    /**
     * [POST-CONDIZIONI] 
     *  stampa tutte le terne per cui a*b != c ma la prova del nove e' corretta
     * 
     * @param n
     * @return stampa tutte le terne per cui a*b != c ma la prova del nove e' corretta
     */
    public static void provaDelNove(int n) {
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                int res = a*b;
                for (int c = 1; c < n; c++) {
                    if (res != c) {
                        if (sumDigits(res) == sumDigits(c)) {
                            System.out.println(a + " " + b + " " + c);
                        }
                    }
                }
            }
        }
    }

    /**
     * [POST-CONDIZIONI]
     *  viene calcolata la somma di tutte le cifre dell'argomento n
     *
     *
     * @param n
     * @return la somma di tutte le cifre del numero
     */
    public static int sumDigits(int n) {
        return n%9;
    }
}