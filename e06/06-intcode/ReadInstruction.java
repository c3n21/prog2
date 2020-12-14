import java.util.Scanner;

import MemoryInterface;

final public class ReadInstruction extends SyscallInstruction {
	public ReadInstruction(MemoryInterface memory, int arg1) {
		super(3, null, memory, arg1);
	}

    /**
     * [EFFECTS]
     *      reads an int on STDIN and writes it to memory in address "arg1"
     * @return true if is all ok, otherwise false
     */
    @Override
    public boolean execute() {
        boolean res = false;
        int value   = 0;

        try(Scanner scanner = new Scanner(System.in)) {
            value = scanner.nextInt();
            res = true;
        } 

        this.memory.set(this.arg1, value);

        return res;
    }
}
