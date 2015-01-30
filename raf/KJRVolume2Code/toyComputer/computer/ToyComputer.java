package computer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/** A simulator for a toy computer with a few instructions. The 
 * computer uses a stack for all computations rather than registers. 
 * @author jbergin
 *
 */
public class ToyComputer {
	/** The memory "array" of this computer
	 */
	private Memory memory = new Memory();
	/** The operational stack on which operations are done
	 */
	private Stack<Double> stack = new Stack<Double>();
	private int loadAddress = 0;
	private boolean running = false;
	/** The program counter used during execution
	 */
	private int pc;
	/** The instruction register or decoder of the CPU
	 */
	private Instruction decoder;
	
	// The legal opcodes
	private static final int push = 0;
	private static final int pop = 1;
	private static final int toss = 2;
	private static final int outp = 3;
	private static final int dupl = 4;
	private static final int add = 5;
	private static final int subtr = 6;
	private static final int halt = 7;
	private static final int inp = 8;
	private static final int jmp = 9;
	private static final int jnn = 10;
	private static final int ldd = 11;
	private static final int zer = 12;
	private static final int inc = 13;
	private static final int lda = 14;
	

	// The execution of the opcodes
	
	
	/** Copies a memory cell and pushes it onto the stack
	 * @param mem the address of the memory cell desired
	 */
	public void push(int mem){
		stack.push(memory.getValue(mem).value());
	}
	
	/** Pop the stack and put the result into memory
	 * @param mem the memory cell address into which to put the 
	 * stack top
	 */
	public void pop(int mem){
		memory.put(new Data(stack.pop()), mem);
	}
	
	/** Discard the top of the stack. Pop, but throws away the result
	 */
	public void toss(){
		stack.pop();
	}
	
	/** Pop the stack and print the result on standard output
	 */
	public void outp(){
		System.out.println(stack.pop());
	}
	
	/** Duplicate the top of the stack. i.e. push a copy of the top 
	 * onto the top
	 */
	public void dupl(){
		stack.push(stack.top());
	}
	
	/** Pop the two top elements from the stack, add them and push 
	 * the result
	 */
	public void add(){
		stack.push(stack.pop() + stack.pop());
	}
	
	/** Pop the two top elements from the stack and subtract them. 
	 * The original top is the left operand and the one below is 
	 * the right operand. Push the result
	 */
	public void subtr(){
		stack.push(stack.pop() - stack.pop());
	}
	
	/** Unconditionally jump to an instruction at the specified address
	 * @param where the address of the next instruction to be executed
	 */
	public void jmp(int where){
		pc = where;
	}
	
	/** Push a zero onto the top of the stack.
	 */
	public void zer(){
		stack.push(0.0);
	}
	
	/** Add 1.0 to the top of the stack. Increment.
	 */
	public void inc(){
		stack.push(stack.pop() + 1.0);
	}
	
	/** The top of the stack is an address. Pop it, extract the 
	 * data item at that address and push the result. Replace 
	 * an address with the item it points to
	 */
	public void ldd(){
		int where = stack.pop().intValue();
		push(where);
	}
	
	/** Pop the stack. If the result is non-negative then jump 
	 * to the specified address
	 * @param where the address of the next instruction of the 
	 * stack top was non-negative
	 */
	public void jnn(int where){
		if(stack.pop().intValue() >= 0){
			pc = where;
		}
	}

	/** Terminate execution of the running program
	 */
	public void halt(){
		running = false;
	}
	
	/** Retrieve a double from standard input and push the result
	 * @throws NumberFormatException if the input can't be 
	 * interpreted as a double
	 */
	public void inp(){
		Scanner in = new Scanner(System.in);
		stack.push(in.nextDouble());
	}
	
	/** Load the address of an operand. Primarily used to get the address
	 * of a label onto the stack
	 * @param where the address to be loaded
	 */
	public void lda(int where){
		stack.push((double)where);
	}
	
	// end of the opcodes
	
	/* the next four methods permit loading of instructions 
	  and data into the computer's memory 
	  in preparation for execution of a program.
	 */
	
	/** Load an instruction into the next available memory 
	 * location starting from zero
	 * @param opcode the opcode of the instruction
	 * @param operand the operand (memory address) that 
	 * the opcode will operate on
	 */
	public void loadInstruction(int opcode, int operand){
		memory.put(new Instruction(opcode, operand), loadAddress++);
	}
	
	/** Load an instruction into the next available memory 
	 * location starting from zero. The 
	 * operand will be set to zero in this instruction
	 * @param opcode the opcode of the instruction
	 */
	public void loadInstruction(int opcode){
		loadInstruction(opcode, 0);
	}
	
	/** Load a data cell at an arbitrary memory address
	 * @param data the double value to be stored (a Data cell 
	 * will be created)
	 * @param location the memory address into which to put the new cell
	 */
	public void loadData(double data, int location){
		memory.put(new Data(data), location);
	}
	
	/** Reset the load address so that a new program may be loaded  
	 * over the current one

	 */
	public void reset(){
		loadAddress = 0;
	}
	
	/** Execute the program currently stored in the memory. 
	 * Starts at address 0 in  all cases. It uses a typical 
	 * fetch-increment-decode-do cycle
	 */
	public void run(){
		pc = 0;
		running = true;
		stack.clear();
		while (running){
			fetch();
			increment();
			decodeDo();
		}
	}
	
	/** Fetch an instruction using the program counter (pc). 
	 * Put it into the decoder in the CPU (Central Processing Unit)
	 */ 
	private void fetch(){
		decoder = (Instruction)memory.getInstruction(pc);
	}
	
	/** Increment the pc
	 */
	private void increment(){
		pc++;
	}
	
	/** Decode the instruction in the decoder (break it into parts) 
	 * and execute it
	 */
	private void decodeDo(){
		perform(decoder.opcode(), decoder.operand());
	}
	
	/** The internal map between opcode numbers and the 
	 * operational methods. Think of this as the internal
	 * wiring of the computer that connects the decoder 
	 * to the various operational units such as an adder, 
	 * the stack, etc. The polymorphic replacement of this
	 * is beyond the scope of the book. 
	 * @param op an opcode
	 * @param opnd the (optional) operand for this opcode
	 */
	private void perform(int op, int opnd){
		switch(op){
		case push: push(opnd);
			break;
		case pop: pop(opnd);
			break;
		case toss: toss();
			break;
		case outp: outp();
			break;
		case dupl: dupl();
			break;
		case add: add();
			break;
		case subtr: subtr();
			break;
		case halt: halt();
			break;
		case inp: inp();
			break;
		case jmp: jmp(opnd);
			break;
		case jnn: jnn(opnd);
			break;
		case ldd: ldd();
			break;
		case zer: zer();
			break;
		case inc: inc();
			break;
		case lda: lda(opnd);
			break;
		default:
			throw new UnsupportedOperationException("Unknown instruction");
		}
	}
	
	public void writeProgram(int numberOfInstructions) throws IOException{
		BufferedWriter outp = new BufferedWriter(new FileWriter("core.txt"));
		for(int i = 0; i < numberOfInstructions; ++i){
			Instruction instruction = memory.getInstruction(i);
			outp.write("" + instruction.opcode() + " " + instruction.operand());
			outp.newLine();
		}
		outp.close();
	}
	
	public static void main (String [] args) throws Exception{
		ToyComputer computer = new ToyComputer();
		
		computer.loadData(1.0, 100); // data to be added
		computer.loadData(2.0, 101);
		computer.loadData(3.0, 102);
		computer.loadData(4.0, 103);
		computer.loadData(0.0, 104); // control counter
		computer.loadData(3.0, 105); //const number of items - 1
		computer.loadData(100.0, 106); // data loc of beginning of data
		
		computer.loadInstruction(zer);
		computer.loadInstruction(push, 104);
		computer.loadInstruction(push, 105);
		computer.loadInstruction(subtr);
		computer.loadInstruction(jnn, 6);
		computer.loadInstruction(jmp, 16);
		computer.loadInstruction(push, 106);
		computer.loadInstruction(ldd);
		computer.loadInstruction(add);
		computer.loadInstruction(push, 104);
		computer.loadInstruction(inc);
		computer.loadInstruction(pop, 104);
		computer.loadInstruction(push, 106);
		computer.loadInstruction(inc);
		computer.loadInstruction(pop, 106);
		computer.loadInstruction(jmp, 1);
		computer.loadInstruction(outp);
		computer.loadInstruction(halt);
		
		
//		computer.loadInstruction(zer, 0);
//		computer.loadInstruction(lda, 20);
//		computer.loadInstruction(pop, 26);
//		computer.loadInstruction(push, 24);
//		computer.loadInstruction(push, 25);
//		computer.loadInstruction(subtr, 0);
//		computer.loadInstruction(jnn, 8);
//		computer.loadInstruction(jmp, 18);
//		computer.loadInstruction(push, 26);
//		computer.loadInstruction(ldd, 0);
//		computer.loadInstruction(add, 0);
//		computer.loadInstruction(push, 24);
//		computer.loadInstruction(inc, 0);
//		computer.loadInstruction(pop, 24);
//		computer.loadInstruction(push, 26);
//		computer.loadInstruction(inc, 0);
//		computer.loadInstruction(pop, 26);
//		computer.loadInstruction(jmp, 3);
//		computer.loadInstruction(outp, 0);
//		computer.loadInstruction(halt, 0);
//		computer.loadData(1.0, 20);
//		computer.loadData(2.0, 21);
//		computer.loadData(3.0, 22);
//		computer.loadData(4.0, 23);
//		computer.loadData(0.0, 24);
//		computer.loadData(3.0, 25);
//		computer.loadData(0.0, 26);
		computer.run();
		
		computer.writeProgram(18);
	}
	
}
