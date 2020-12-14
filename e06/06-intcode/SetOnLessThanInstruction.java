
import src.vm.memory.Writebackable;

final public class SetOnLessThanInstruction extends SetOnInstruction {

	public SetOnLessThanInstruction(Writebackable memory, int arg1, int arg2, int arg3) {
		super(memory, 7, arg1, arg2, arg3);
	}

    @Override
    public boolean execute() {
        boolean res = arg1 < arg2;

        if (res) this.result = 1;
        super.execute();

        return res;
    }
}
