import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        IntQueue intQueue = new IntQueue();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            
            for (int i = 0; scanner.hasNext() && i < n; i++) {
                intQueue.enqueue(scanner.nextInt());
            }


            for (int i = 0; i < n/3; i++) {
                intQueue.dequeue();
            }
        }

        for (Iterator<Integer> it = intQueue.elements(); 
                it.hasNext();
                ) {
            System.out.println(it.next()); 
        }
    }
}
