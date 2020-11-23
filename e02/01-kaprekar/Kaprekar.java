import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);

                printKaprekarSequence(scanner.nextInt());

                scanner.close();
        }

        /**
         * [EFFECTS]
         *      prints the kaprekar sequence of <code> n </code>
         *      @throws IllegalArgumentException
         *
         * @param n
         * 
         * */ 
        public static void printKaprekarSequence (int n) {
                if (n < 1000) {
                        throw new IllegalArgumentException("Argument is lower than 1000");
                } 

                if (n > 9999) {
                        throw new IllegalArgumentException("Argument is higher than 9999");
                } 

                /**
                 * [1] riordinare le cifre in ordine decrescente
                 * [2] riordinare le cifre in ordine crescente
                 * [3] sottrarre i numeri
                 * [4] ripetere da [1] fino a quando non si ottiene 6174
                 * */
                do {
                        System.out.println(n);
                } while ( n != (n = sortDigitsDescending(n) - sortDigitsAscending(n)));

        }

        /**
         *  [EFFECTS]
         *      returns the the number n with its digits sorted in ascending order.
         * */
        public static int sortDigitsAscending ( int n ) {
                String str = "" + n;
                char [] digits = str.toCharArray();
                Arrays.sort(digits);
                int res = Integer.parseInt(new String(digits));
                return res;
        }

        /**
         *  [EFFECTS]
         *      returns the the number n with its digits sorted in descending order.
         * */
        public static int sortDigitsDescending ( int n ) {
                String str = "" + n;
                char [] digits = str.toCharArray();
                Arrays.sort(digits);
                int res = Integer.parseInt(
                                new StringBuilder(
                                        new String(digits)
                                        ).reverse().toString()
                                );
                return res;
        }

}