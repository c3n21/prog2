
import src.vm.register.RegisterInterface;

public class AddRBRInstruction extends SyscallInstruction {

	public AddRBRInstruction(RegisterInterface relative_base_reg, int arg1) {
		super(9, relative_base_reg, null, arg1);
	}

    @Override
    public boolean execute() {
        relative_base_reg.set(relative_base_reg.get() + arg1);
        return true;
    }
}
