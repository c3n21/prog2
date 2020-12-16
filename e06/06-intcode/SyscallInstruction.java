

/**
 * {@code 
 * [OVERVIEW] 
 *      SyscallInstruction puo' assumere i seguenti OPCODE}
 *
 */

public abstract class SyscallInstruction extends Instruction {
    final protected int arg1;
    final protected RegisterInterface relative_base_reg;
    final protected MemoryInterface memory;

	public SyscallInstruction(int opcode, RegisterInterface relative_base_reg, MemoryInterface memory, int arg1) {
		super(opcode);
        this.memory            = memory;
        this.relative_base_reg = relative_base_reg;
        this.arg1              = arg1;
	}
}
