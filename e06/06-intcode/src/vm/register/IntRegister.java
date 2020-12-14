package src.vm.register;

final public class IntRegister implements RegisterInterface {
    private int register;

    public IntRegister() {
        register = 0;
    }

	@Override
	public void set(int value) {
	    register = value;
	}

	@Override
	public int get() {
	    return register;
	}
}
