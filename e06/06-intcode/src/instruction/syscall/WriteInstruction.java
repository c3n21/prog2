package src.instruction.syscall;

final public class WriteInstruction extends SyscallInstruction {

	public WriteInstruction(int arg1) {
		super(4, null, null, arg1);
	}

    @Override
    public boolean execute() {
        System.out.println(arg1);
        return true;
    }
}
