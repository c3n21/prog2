import java.util.Scanner;

public class Test {
        public static void main(String args[]) {
                IntSet set = new IntSet();

                try (Scanner scanner = new Scanner(System.in)) {
                        while (scanner.hasNext()) {
                                set.insert(scanner.nextInt());
                        }
                }

                System.out.println(set.size());
        }
}