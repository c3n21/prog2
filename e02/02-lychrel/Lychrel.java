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
     * [REQUIRES]
     *      n non e' un numero di Lychrel
     * [EFFECTS]
     *      stampa la sequenza di Lychrel
     * 
     * @param n
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
	 * [EFFECTS] 
     *      restituisce la stringa del numero number invertita
     * 
     * @param number
     * @return stringa del numero number
     * 
     */
	private static String longToString(long number) {
		return "" + number;
	}

	/**
	 * [EFFECTS] un long che rappresenta str_number
     * 
     * @param str_number
     * 
     * @return long che rappresenta str_number
     * 
     * @throws IllegalArgumentException se {@code String str_number} 
     *  non e' parsabile
     */
	private static long stringToLong(String str_number) {
        long res = 0;

        try {
            res = Long.parseLong(str_number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Il numero " + str_number + " non e' possibile da parsare",
                e
            );
        }

		return res;
	}

	/**
	 * [EFFECTS] 
     *      restituisce la stringa invertita
     * 
     * @param str qualsiasi {@code String} 
     * 
     * @return {@code String} che rappresenta @param str invertito
	 */
	private static String invertString(final String str) {
		final StringBuilder string = new StringBuilder(str);
		return string.reverse().toString();
	}

	/*
	
	 * [EFFECTS] 
     *      restituisce la stringa del numero number invertita
	 */
	private static boolean isPalindrome(final String str) {
		if (str == null) {
			throw new IllegalArgumentException("str must NOT be null");
		}

		boolean res = true;
		
		for (int i = 0, len = str.length() - 1; 
			i < len && (res = str.charAt(i) == str.charAt(len));
			i++, len--);

		return res;
	}
}