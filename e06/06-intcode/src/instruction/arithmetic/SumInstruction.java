package src.instruction.arithmetic;

import src.vm.memory.Writebackable;

final public class SumInstruction extends ArithmeticInstruction{

	public SumInstruction(Writebackable memory, int arg1, int arg2, int arg3) {
		super(1, memory, arg1, arg2, arg3);
	}

    @Override
    public boolean execute() {
        res = arg1 + arg2;
        return super.execute();
    }
}
