/**
 * [OVERVIEW]
 *      Memory represents the central memory of a VonNeumann machine
 *
 */

public class Memory implements MemoryInterface, Writebackable{
    final private int memory[];
    private int segment_end;

    /**
     * [ABS FUN]
     *      AF(memory) = [0 ... n-1] is an array of int n cells
     *
     * [REP INV]
     *      memory != null
     *
     * [ABS INV]
     */

    public Memory(int data[]) {
        this.memory = data;
        this.segment_end = data.length;
    }

    /**
     * [EFFECTS]
     *      fetches the instruction in position instruction_ptr
     *
     * @param instruction_ptr position of the instruction to be fetched
     *
     * @return content of the indicated memory cell
     *
     * @throws IllegalAccessError if instruction_ptr is negative or out of bounds
     */
    @Override
    public int fetch(int instruction_ptr) {
        if(instruction_ptr < 0 || instruction_ptr >= memory.length) {
            throw new IllegalAccessError("Accessing out of bounds memory, IP = " + instruction_ptr);
        }

        return memory[instruction_ptr];
    }

    /**
     * [EFFECTS]
     *      set the value at address "address" with "value"
     *
        * @throws IndexOutOfBoundsException if 0 < "address" < memory.size()
     *
     */
	@Override
	public void set(int address, int value) {
        memory[address] = value;
	}

	@Override
	public int fetchInstruction(int address) {
        if (address < this.segment_end) {
            return memory[address];
        }

        throw new UnsupportedOperationException("Da cambiare questa eccezione in Memory!");//finite istruzioni programma
	}

	@Override
	public void setSegmentEnd(int segment_end) {
        if(segment_end >= memory.length || segment_end < 0) {
            throw new IndexOutOfBoundsException("Segment end is out of bounds! segment_end = " + segment_end);
        }

        this.segment_end = segment_end;
	}

	@Override
	public void write(int address, int result) {
        memory[address] = result;
	}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Memory : [");

        for (int i = 0; i < memory.length; i++) {
            stringBuilder.append(memory[i]);
            if (i == memory.length-1) {
                break;
            }
            stringBuilder.append(",");
            
        }
        for (int i : memory) {
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSegmentEnd() {
        return segment_end;
    }
}
