
import src.instruction.Instruction;
import src.vm.register.RegisterInterface;

public abstract class BranchInstruction extends Instruction {
    final protected int arg1, arg2;
    final protected RegisterInterface instruction_register;
    
    public BranchInstruction(int opcode, RegisterInterface instruction_register, int arg1, int arg2) {
        super(opcode);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.instruction_register = instruction_register;
    }
}
