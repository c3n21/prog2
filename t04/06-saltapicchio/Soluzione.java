import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        Scanner scanner        = new Scanner(System.in);
        int n                  = Integer.parseInt(args[0]);
        int [] seq             = new int[n];
        boolean [] check       = new boolean[n-1];
        boolean isSaltapicchio = true;
        
        for(int i = 0; scanner.hasNext() && i < n ; i++) {
            
            seq[i] = scanner.nextInt();
            //System.out.println("seq = " + seq[i]);
        }

        for(int i = 0; i < n-1; i++) {
            try { //<----- change this crap
                check[Math.abs(seq[i] - seq[i+1])- 1] = true;    
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception
            }
            
        }

        for(int i = 0; i < n-1 && isSaltapicchio; i++) {
            //System.out.println("i = " + i + "; check[" + i + "] = " + check[i]);
            if(!check[i]) {
                isSaltapicchio = false;
            }
        }

        if(isSaltapicchio) {
            System.out.println("saltapicchio");
        }

        scanner.close();
    }
}