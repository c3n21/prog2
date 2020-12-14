package src.vm.memory;

public interface MemoryInterface {
    public int fetchInstruction(int address);
    public int fetch(int address);
    public void set(int address, int value);
    public void setSegmentEnd(int segment_end);
}
