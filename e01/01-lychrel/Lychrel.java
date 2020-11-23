import java.util.Scanner;
import java.lang.StringBuilder;

public class Lychrel {

	public static void main(final String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            lychrelSequence(scanner.nextLong());
        }
        

        scanner.close();
    }
    /**
     * [Pre-condizioni]
     *  n non è un numero di Lychrel
     * [Post-condizioni]
     *  stampa la sequenza di Lychrel
     * 
     * @param number
     * 
     */

    public static void lychrelSequence(long n) {
        String str_sum = "";
        System.out.println(n);
        
        do {
            String str_inv_n = invertString(longToString(n));
            long inv_n = stringToLong(str_inv_n);
            long sum = n + inv_n;
            str_sum = longToString(sum);
            System.out.println(str_sum);
            
            n = sum;
        }while (!isPalindrome(str_sum));
    }

    /**
     * [Pre-condizioni] 
     *  >un numero rappresentabile con un long
	 * [Post-condizioni] restituisce la stringa del numero number invertita
     * 
     * @param number
     * @return stringa del numero number
     * 
     */
	private static String longToString(long number) {
		return "" + number;
	}

	/**
	 * [Pre-condizioni] 
     *  >str_number deve essere una stringa che rappresenta un numero in base 10
     *  >deve essere rappresentabile al più come un long
     *  >non deve essere null
	 * [Post-condizioni] un long che rappresenta str_number
     * 
     * @param str_number
     * @return long che rappresenta str_number
	 */
	private static long stringToLong(String str_number) {
        long res = 0;
        for (int i = 0, len = str_number.length(); i < len; i++) {
            res *= 10;
            res += str_number.charAt(i) - '0';
        }

		return res;
	}

	/*
	 * [Pre-condizioni]
	 * 	>la stringa deve rappresentare un numero in base al massimo 10
     *  >la stringa non deve essere null
	 * [Post-condizioni] restituisce la stringa del numero number invertita
	 */
	private static String invertString(final String number) {
		final StringBuilder str = new StringBuilder(number);
		return str.reverse().toString();
	}

	/*
	 * [Pre-condizioni] -> serve mettere la precondizione in questo caso dato che faccio già il controllo?
	 * [Post-condizioni] restituisce la stringa del numero number invertita
	 */
	private static boolean isPalindrome(final String str) {
		if (str == null) {
			return false;
		}

		boolean res = true;
		
		for (int i = 0, len = str.length() - 1; 
			i < len && (res = str.charAt(i) == str.charAt(len));
			i++, len--);

		return res;
	}
}