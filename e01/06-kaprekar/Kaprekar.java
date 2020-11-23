import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {
        public static void main(String args[]) {
                Scanner scanner = new Scanner(System.in);

                kaprekar(scanner.nextInt());

                scanner.close();
        }

        /**
         * [REQUIRES]
         *  input must be a 4 digit long number and must have at least 2 different digits
         *
         * [MODIFIES]
         *  n
         *  STDOUT
         *
         * [EFFECTS]
         *  prints out kaprekar sequence 
         *
         * */
        public static void kaprekar(int n) {

            while(n != 6174) {
                System.out.println(n);
                char ch_n [] = Integer.toString(n).toCharArray();
                Arrays.sort(ch_n);
                String str = new String(ch_n);
                int n2 = Integer.parseInt(str);
                StringBuilder reversed_str = new StringBuilder(str);
                int n1 = Integer.parseInt(
                    reversed_str.reverse().toString()
                );
                n = n1 - n2;     
            }  
            System.out.println(n);             
        }
}