package computer;

/** Represents an instruction cell in the memory of the toy 
 * computer. An instruction has an opcode and an operand. T
 * he operand might not be used by every instruction
 * @author jbergin
 *
 */
public class Instruction implements Code{
	private int opcode;
	private int operand;
	
	/** Create an insctuction cell that may be placed in 
	 * the memory of a toy computer
	 * @param operation the opcode 
	 * @param onWhat the operand
	 */
	public Instruction(int operation, int onWhat){
		opcode = operation;
		operand = onWhat;
	}
	
	/** Retrieve the opcode of this instruction
	 * @return the instruction code itself in integer form
	 */
	public int opcode(){
		return opcode;
	}
	
	/** Retrieve the operand of this instruction. It will 
	 * likely be 0 if the opcode 
	 * doesn't use any operand
	 * @return the operand, which is always an address in the 
	 * memory of the toy computer. 
	 */
	public int operand(){
		return operand;
	}
	
}
