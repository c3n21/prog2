package src.instruction;

public abstract class Instruction {
    final public int opcode;

    public Instruction(int opcode) {
        if ((opcode > 9 && opcode < 99) || (opcode < 1) || (opcode > 99)) { //opcode < 1, opcode > 99, 9 < opcode < 99
            throw new IllegalArgumentException("OPCODE not supported! opcode = " + opcode);
        }

//        if (access_mode < 0 || access_mode > 2) {
//            throw new IllegalArgumentException("ACCESS MODE not supported! access_mode = " + access_mode);
//        }
//
//        this.access_mode = access_mode;
        this.opcode = opcode;
    }

    public boolean execute() {
        throw new UnsupportedOperationException(this.getClass() + ".execute() non implementata!");
    };
}
