import java.util.Scanner;


public class Test {
    public static void main(String args[]) {

        IntCodeVirtualMachine vm;
        int raw_ints[];
        try (Scanner scanner = new Scanner(System.in)) {
            String instructions[] = scanner.nextLine().split(",");
            raw_ints = new int[instructions.length];

            for (int i = 0; i < instructions.length; i++) {
                raw_ints[i] = Integer.parseInt(instructions[i]);
            }
        }
        
    }
}
