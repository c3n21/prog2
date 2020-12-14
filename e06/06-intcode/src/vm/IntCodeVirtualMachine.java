package src.vm;

import src.instruction.arithmetic.MultInstruction;
import src.instruction.arithmetic.SumInstruction;
import src.instruction.branch.BranchEqualZeroInstruction;
import src.instruction.branch.BranchNotEqualZeroInstruction;
import src.instruction.seton.SetOnEqualsInstruction;
import src.instruction.seton.SetOnLessThanInstruction;
import src.instruction.syscall.AddRBRInstruction;
import src.instruction.syscall.HaltInstruction;
import src.instruction.syscall.ReadInstruction;
import src.instruction.syscall.WriteInstruction;

import java.util.Scanner;

import src.instruction.Instruction;
import src.vm.memory.Memory;
import src.vm.register.IntRegister;

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

    public void run(int instructions[], String args[]) {
        for (int instruction: instructions) {
            execute(decode(instruction));
        }
    }

    private boolean execute(Instruction instruction) {
        return instruction.execute();
    }

	private Instruction decode(int instruction) {
        
        String formatted_instruction = String.format("%05d", instruction);
        String opcode = formatted_instruction.substring(3);
        int args[] = getArguments(formatted_instruction);

        if (opcode.equals("01")) {
            return new SumInstruction(memory, args[0], args[1], args[2]);
        }

        if (opcode.equals("02")) {
            return new MultInstruction(memory, args[0], args[1], args[2]);
        }

        if (opcode.equals("03")) {
            return new ReadInstruction(memory, args[0]);
        }

        if (opcode.equals("04")) {
            return new WriteInstruction(args[0]);
        }

        if (opcode.equals("05")) {
            return new BranchNotEqualZeroInstruction(instruction_reg, args[0], args[1]);
        }

        if (opcode.equals("06")) {
            return new BranchEqualZeroInstruction(instruction_reg, args[0], args[1]);
        }

        if (opcode.equals("07")) {
            return new SetOnLessThanInstruction(memory, args[0], args[1], args[2]);
        }

        if (opcode.equals("08")) {
            return new SetOnEqualsInstruction(memory, args[0], args[1], args[2]);
        }

        if (opcode.equals("09")) {
            return new AddRBRInstruction(relative_base_reg, args[0]);
        }

        if (opcode.equals("99")) {
            return new HaltInstruction(memory, instruction_reg.get());
        }

        throw new UnsupportedOperationException(String.format("Operazione con OPCODE '%s' non è supportata", opcode));
	}
    
    private int[] getArguments(String formatted_instruction) {
        int args[] = new int[3];

        for (int i = 0; i < 3; i++) {
            switch(formatted_instruction.charAt(i)) {
                case '0':
                    args[i] = memory.fetch(instruction_reg.get());
                    instruction_reg.set(instruction_reg.get()+1);
                    break;
                case '1':
                    try(Scanner scanner = new Scanner(System.in)) {
                        args[i] = scanner.nextInt();
                    }

                    break;
                case '3':
                    int offset;
                    try(Scanner scanner = new Scanner(System.in)) {
                        offset = scanner.nextInt();
                        args[i] = memory.fetch(relative_base_reg.get()+offset);
                    }
                    break;
                default:
                        throw new IllegalAccessError("Metodo d'accesso non supportato");
            }
        }
        return args;
    }
}
