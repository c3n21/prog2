package src.instruction.branch;

import src.vm.register.RegisterInterface;

final public class BranchEqualZeroInstruction extends BranchInstruction {

	public BranchEqualZeroInstruction(RegisterInterface instruction_register, int arg1, int arg2) {
		super(6, instruction_register, arg1, arg2);
	}

	@Override
	public boolean execute() {
	    if(arg1 == 0) {
            instruction_register.set(arg2);
            return true;
        } 

        return false;
	}
}
