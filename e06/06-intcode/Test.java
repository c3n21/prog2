import java.util.Scanner;

public class Test {
    public static void main(String args[]) {

        IntCodeVirtualMachine vm;
        int raw_ints[];
        String instructions[] = args[0].split(",");
        raw_ints = new int[instructions.length];

        for (int i = 0; i < instructions.length; i++) {
            raw_ints[i] = Integer.parseInt(instructions[i]);
        }

        vm = new IntCodeVirtualMachine(raw_ints);
        vm.run();
        System.out.println(vm);
    }
}
