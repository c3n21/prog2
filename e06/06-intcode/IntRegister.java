final public class IntRegister implements RegisterInterface {
    private int register;

    public IntRegister() {
        register = 0;
    }

	@Override
	public RegisterInterface set(int value) {
	    register = value;
        return this;
	}

	@Override
	public int get() {
	    return register;
	}
}
