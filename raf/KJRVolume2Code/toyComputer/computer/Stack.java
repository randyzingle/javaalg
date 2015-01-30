package computer;

import com.jbergin.generic.DenseList;

/** A LIFO storage structure. Useful in such things as language translation and in execution of 
 * arithmetic expressions. Insertions are only at the "top". Removals are only at the "top". 
 * @author jbergin
 *
 * @param <T> the type of element stored
 */
public class Stack<T>{
	private DenseList<T> storage = new DenseList<T>();
	
	/** Enter an item into the storage at the top. 
	 * @param element the item to be inserted
	 */
	public void push(T element){
		storage.add(element);
	}
	
	/** Remove and return the item most recently pushed that 
	 * has not yet been popped
	 * @return the top of the stack
	 * @throws IllegalStateException if the stack is empty
	 */
	public T pop(){
		if(storage.isEmpty()){
			throw new IllegalStateException("Pop of empty stack");
		}
		int last = storage.size() - 1;
		T result = storage.get(last);
		storage.remove(last);
		return result;
	}
	
	/** Get a reference to the top of the stack without removing it. 
	 * @return the item at the top of the stack
	 * @throws IllegalStateException if the stack is empty
	 */
	public T top(){
		if(storage.size() == 0){
			throw new IllegalStateException("Pop of empty stack");
		}
		return storage.get(storage.size() - 1);
	}
	
	/** Tells if the structure is empty.
	 * @return whether or not the stack is empty (has no elements)
	 */
	public boolean isEmpty(){
		return storage.isEmpty();
	}
	
	/** Empty the stack
	 */
	public void clear(){
		storage.clear();
	}
}