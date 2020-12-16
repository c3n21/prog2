public abstract class ArithmeticInstruction extends Instruction{

    final protected int arg1, arg2, arg3;
    protected int res;
    final private Writebackable memory;

	protected ArithmeticInstruction(int opcode, Writebackable memory, int arg1, int arg2, int arg3) {
		super(opcode);

        this.memory = memory;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
	}

    @Override
    public boolean execute() {
        memory.write(arg3, res);
        return true;
    }

    final public static Instruction createArithmeticInstruction(String opcode, Writebackable memory, int arg1, int arg2, int arg3) {
        if (opcode.equals("01")) {
            return new SumInstruction(memory, arg1, arg2, arg3);
        }

        if (opcode.equals("02")) {
            return new MultInstruction(memory, arg1, arg2, arg3);
        }

        throw new IllegalArgumentException("opcode = " + opcode + " not supported!");
    }
}
