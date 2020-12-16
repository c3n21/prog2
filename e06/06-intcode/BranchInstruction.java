public abstract class BranchInstruction extends Instruction {
    final protected int arg1, arg2;
    final protected RegisterInterface instruction_register;
    
    public BranchInstruction(int opcode, RegisterInterface instruction_register, int arg1, int arg2) {
        super(opcode);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.instruction_register = instruction_register;
    }

    final public static Instruction createBranchInstruction(String opcode, RegisterInterface instruction_register, int arg1, int arg2) {
        if (opcode.equals("05")) {
            return new BranchNotEqualZeroInstruction(instruction_register, arg1, arg2);
        } 

        if (opcode.equals("06")) {
            return new BranchEqualZeroInstruction(instruction_register, arg1, arg2);
        }

        throw new IllegalArgumentException("opcode = " + opcode + " not supported!");
    }
}
