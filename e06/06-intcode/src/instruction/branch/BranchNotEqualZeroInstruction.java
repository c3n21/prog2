package src.instruction.branch;

import src.vm.register.RegisterInterface;

final public class BranchNotEqualZeroInstruction extends BranchInstruction {
    public BranchNotEqualZeroInstruction(RegisterInterface instruction_reg, int arg1, int arg2) {
        super(5, instruction_reg, arg1, arg2);
    }

    /**
     * @return true if arg1 != 0, else false
     */
	@Override
	public boolean execute() {
	    if(arg1 != 0) {
            instruction_register.set(arg2);
            return true;
        }

        return false;
	}
}
