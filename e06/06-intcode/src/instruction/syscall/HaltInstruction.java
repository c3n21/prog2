package src.instruction.syscall;

import src.vm.memory.MemoryInterface;

final public class HaltInstruction extends SyscallInstruction {
    final private int address;

	public HaltInstruction(MemoryInterface memory, int address) {
		super(99, null, memory, 0);
        this.address = address;
	}

    @Override
    public boolean execute() {
        this.memory.setSegmentEnd(address);
        return true;
    }
}
