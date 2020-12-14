import Writebackable;

final public class MultInstruction extends ArithmeticInstruction{

    public MultInstruction(Writebackable memory, int arg1, int arg2, int arg3) {
        super(2, memory, arg1, arg2, arg3);
	}

    @Override
    public boolean execute() {
        res = arg1 * arg2;
        return super.execute();
    }
}
