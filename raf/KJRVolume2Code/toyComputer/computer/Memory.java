package computer;

import com.jbergin.generic.DenseList;

/** A dense array-like structure representing the memory of a toy 
 * computer. The memory may hold cells of type Code, either 
 * Data cells or Instruction cells. 
 * @author jbergin
 *
 */
public class Memory{
	private DenseList<Code> storage = new DenseList<Code>(1024);
	
	/** Create a memory of size 1K or 1024 cells. 
	 * 
	 */
	public Memory(){
		for(int i = 0; i < 1024; ++i){
			storage.add(null);
		}
	}
	
	/** Insert a cell into the memory at a fixed address
	 * @param code the cell to be inserted. It may be Data or 
	 * Instruction
	 * @param cell the address at which to put the item in 
	 * range: 0..1023
	 */
	public void put(Code code, int cell){
		storage.set(cell, code);
	}
	
	/** Retrieve a data cell from the memory. An error will occur 
	 * if it isn't a data cell
	 * @param cell the address of the desired cell
	 * @return the cell at the required address
	 * @throws ClassCastException if the cell has the wrong type
	 */
	public Data getValue(int cell){
			return (Data)storage.get(cell);
	}
	
	/** Retrieve an instruction cell from the memory. An error will 
	 * occur if it isn't
	 * an instruction cell
	 * @param cell the address of the desired cell
	 * @return the cell at the required address
	 * @throws ClassCastException if the cell has the wrong type
	 */
	public Instruction getInstruction(int cell){
		return (Instruction)storage.get(cell);
	}
}
