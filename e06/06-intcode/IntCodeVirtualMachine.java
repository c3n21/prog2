import java.util.Scanner;
/**
 * Questa classe rappresenta la macchina virtuale che serve per compilare il linguaggio IntCode tramite un'architettura
 * di VonNeumann
 */

final public class IntCodeVirtualMachine {
    final private IntRegister instruction_reg;
    final private IntRegister relative_base_reg;
    final private Memory memory;

    /**
     * [ABS FUN]
     *      
     * [REP INV]
     *      instruction_ptr >= 0 && < memory.size()
     */

    public IntCodeVirtualMachine(int instructions[]) {
        memory            = new Memory(instructions);
        instruction_reg   = new IntRegister();
        relative_base_reg = new IntRegister();
    }

    public void run() {
        while (memory.getSegmentEnd() > instruction_reg.get()) {
//            System.out.println(String.format("Run: setSegmentEnd %d > instruction_ptr %d", memory.getSegmentEnd(), instruction_reg.get()));
            int intcode_instruction = memory.fetchInstruction(instruction_reg.get()); 

//            System.out.println(
//                    "Run: Executing " + intcode_instruction + " instruction_ptr = " + instruction_reg.get());

            Instruction instruction = decode(intcode_instruction);

//            System.out.println("Run: before " + memory);
            execute(instruction);
//            System.out.println("Run: " + instruction);
//            System.out.println("Run: after " + memory);

            instruction_reg.set(instruction_reg.get() + 1);
        }
//        System.out.println(
//                "Run: current " + instruction_reg.get());
    }

    private boolean execute(Instruction instruction) {
        return instruction.execute();
    }

	private Instruction decode(int instruction) {

//        System.out.println("Decode: instruction = " + instruction);
        
        String formatted_instruction = String.format("%05d", instruction);
        String opcode = formatted_instruction.substring(3);

        if (opcode.equals("99")) {
            return new HaltInstruction(memory, instruction_reg.get());
        }

        if (opcode.equals("01") || opcode.equals("02")) {
            return ArithmeticInstruction.createArithmeticInstruction(opcode, memory, 
                    memory.fetch(getParameterAddress(formatted_instruction.charAt(0))),
                    memory.fetch(getParameterAddress(formatted_instruction.charAt(1))),
                    getParameterAddress(formatted_instruction.charAt(2)));
//            return new SumInstruction(memory,
//                    getParameterAddress(formatted_instruction.charAt(0)),
//                    getParameterAddress(formatted_instruction.charAt(1)), 
//                    memory.fetch(instruction_reg.set()));
        }

        if (opcode.equals("03")) {
            int args[] = getArguments(formatted_instruction, 1);
            return new ReadInstruction(memory, args[0]);
        }

        if (opcode.equals("04")) {
            //int args[] = getArguments(formatted_instruction, 1);
            return new WriteInstruction(memory.fetch(getParameterAddress(formatted_instruction.charAt(0))));
        }

        if (opcode.equals("05") || opcode.equals("06")) {
//            int args[] = getArguments(formatted_instruction, 2);
//            return new BranchNotEqualZeroInstruction(instruction_reg, args[0], args[1]);

            return BranchInstruction.createBranchInstruction(opcode, instruction_reg, 
                    memory.fetch(getParameterAddress(formatted_instruction.charAt(0))),
                    getParameterAddress(formatted_instruction.charAt(1)));
        }

        if (opcode.equals("07") || opcode.equals("08")) {
            int args[] = getArguments(formatted_instruction, 3);
            //return new SetOnLessThanInstruction(memory, args[0], args[1], args[2]);
            return SetOnInstruction.createSetOnInstruction(opcode, memory, 
                    memory.fetch(getParameterAddress(formatted_instruction.charAt(0))),
                    memory.fetch(getParameterAddress(formatted_instruction.charAt(1))),
                    getParameterAddress(formatted_instruction.charAt(2))
                    );
        }

//        if () {
//            int args[] = getArguments(formatted_instruction, 3);
//            return new SetOnEqualsInstruction(memory, args[0], args[1], args[2]);
//        }

        if (opcode.equals("09")) {
            int args[] = getArguments(formatted_instruction, 1);
            return new AddRBRInstruction(relative_base_reg, args[0]);
        }

        throw new UnsupportedOperationException(String.format("Operazione con OPCODE '%s' non e' supportata", opcode));
	}
    
    /**
     * [EFFECTS]
     *      si occupa di fetchare gli argomenti
     */
    private int[] getArguments(String formatted_instruction, int n_args) {
        int args[] = new int[n_args];

        switch(n_args) {
            case 1:
                args[0] = getParameterAddress(formatted_instruction.charAt(0));
                break;
            case 2:
                args[0] = memory.fetch(formatted_instruction.charAt(0));
                args[1] = getParameterAddress(formatted_instruction.charAt(1));
                break;
            case 3:
                args[0] = memory.fetch(getParameterAddress(formatted_instruction.charAt(0)));
                args[1] = memory.fetch(getParameterAddress(formatted_instruction.charAt(1)));
                args[2] = getParameterAddress(formatted_instruction.charAt(2));
                break;
        }

//        System.out.print("getArguments: [");
//        for (int i = 0; i < args.length; i++) {
//            System.out.print(args[i] + ",");
//        }
//        System.out.println("\b]");

        return args;
    }

    final private int retrieveParameter() {
        return 0;
    }

    final private int getParameterAddress(char access_mode) {
        int res;
        instruction_reg.set(instruction_reg.get()+1);
        switch(access_mode) {
            case '0':
                res = memory.fetch(instruction_reg.get());
                //res = memory.fetch(parameter);
                break;
            case '1':
                res = instruction_reg.get();
                break;
            case '2':
                int offset = instruction_reg.get();
                relative_base_reg.set(relative_base_reg.get() + offset);
                res = memory.fetch(relative_base_reg.get());
                break;
            default:
                throw new IllegalAccessError("Metodo d'accesso non supportato");
        }

        return res;
    }

    @Override
    public String toString() {
        String string = "IntcodeVM :\n";
        string += "\t" + memory + "\n";
        string += String.format("\tRegisters : [IP = %d, RBP = %d]", instruction_reg.get(), relative_base_reg.get());
        return string;
    }
}
