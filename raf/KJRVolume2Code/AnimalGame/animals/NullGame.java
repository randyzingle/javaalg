/**
 * 
 */
package animals;

import java.io.BufferedWriter;
import java.io.IOException;

/** Represents a leaf node in an Animal Game. Note that it is a singleton there
 * as it is stateless, so only one is needed. Singleton is not enforced, however.
 * @author jbergin
 *
 */
public class NullGame implements AnimalGame
{
	public void save(BufferedWriter file) throws IOException
	{
		file.write("null");
		file.newLine();
	}
	
	public String animal()
	{
		return "error";
	}
	
	public void repeat()
	{
		// nothing
	}
	
	public void tryNoSide()
	{
		// nothing		
	}
	
	public void tryYesSide()
	{
		// nothing
	}
	
	public void play()
	{
		// nothing
	}
	
	private NullGame(){ }
	
	public static final NullGame leaf = new NullGame();
}