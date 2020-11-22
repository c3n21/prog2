import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test {
    public static void main (String args[]) {
        IntSet intSet = new IntSet();
        try (Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                intSet.insert(n);
            }
        } 
        System.out.println(intSet.size());
    }
}
