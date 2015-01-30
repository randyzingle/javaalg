package computer;

/** Represents data cells in the memory of the toy computer. 
 * Holds a single double value. We depend on auto-boxing of 
 * Java 5 here as the typical use is double, not Double. 
 * @author jbergin
 *
 */
public class Data implements Code{
	private Double data;
	
	/** Create a data cell holding a double that may be 
	 * inserted into the memory
	 * @param d
	 */
	public Data(Double d){
		this.data = d;
	}
	
	/** Retrieve the double value of this cell
	 * @return the double value
	 */
	public Double value(){
		return data;
	}
	
}
