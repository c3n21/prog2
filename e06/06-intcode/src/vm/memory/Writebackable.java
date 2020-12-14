package src.vm.memory;

public interface Writebackable {
    public void write(int address, int result);
}
