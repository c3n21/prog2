public abstract class SetOnInstruction extends Instruction{
    protected final int arg1, arg2, arg3;
    protected int result;
    private final Writebackable memory;


    public SetOnInstruction(Writebackable memory, int opcode, int arg1, int arg2, int arg3) {
        super(opcode);
        this.arg1   = arg1;
        this.arg2   = arg2;
        this.arg3   = arg3;
        this.result = 0;
        this.memory = memory;
    }

    @Override
    public boolean execute() {
        memory.write(arg3, result);
        return true;
    }

    final public static Instruction createSetOnInstruction(String opcode, Writebackable memory, int arg1, int arg2, int arg3) {
        if (opcode.equals("07")) {
            return new SetOnLessThanInstruction(memory, arg1, arg2, arg3);
        } 

        if (opcode.equals("08")) {
            return new SetOnEqualsInstruction(memory, arg1, arg2, arg3);
        }

        throw new IllegalArgumentException("opcode = " + opcode + " not supported!");
    }
}
