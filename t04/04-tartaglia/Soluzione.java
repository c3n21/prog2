import java.util.Scanner;

public class Soluzione {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for(int i = 1; i <= n; i++) {
            System.out.print(tartaglia(n, i) + " ");
        }
        

        scanner.close();
    }

    /**
     * Pre-requisiti: riga > 0, colonna <= riga && colonna > 0
     * Post-condizioni: ottieni il numero di tartaglia in posizione riga e colonna
     * Effetti collaterali: 
     * 
     * @param riga
     * @param colonna
     * @return 
     */

    public static int tartaglia(int riga, int colonna) {
        if(riga == 1) {
            return 1;
        }

        if(colonna == 1 || colonna >= riga) { //primo numero o ultimo numero di una riga (per colonna > riga tengo conto che indica l'ultimo)
            return 1;
        }
        
        return (tartaglia(riga-1, colonna) + tartaglia(riga-1, colonna-1));
    }
}