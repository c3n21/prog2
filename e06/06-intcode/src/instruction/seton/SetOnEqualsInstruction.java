package src.instruction.seton;

import src.vm.memory.Writebackable;

final public class SetOnEqualsInstruction extends SetOnInstruction {

	public SetOnEqualsInstruction(Writebackable memory, int arg1, int arg2, int arg3) {
		super(memory, 8, arg1, arg2, arg3);
	}

    @Override
    public boolean execute() {
        boolean res = arg1 == arg2;

        if (res) this.result = 1;
        super.execute();

        return res;
    }
}
