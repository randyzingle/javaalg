package animals;

import java.io.BufferedWriter;
import java.io.IOException;

/** Represents a node in an Animal Game game tree. There are two implementers, one
 * for leaf nodes (NullGame) and one for non-leaf nodes (Game). 
 * @author jbergin
 *
 */
interface AnimalGame
{
	 /** Recursively writes out the entire game tree (pre-order).
	 * @param file the file to write to
	 * @throws IOException
	 */
	void save(BufferedWriter file) throws IOException;
	 
	 /** The basic play of the game except for the initialization. Recursive.
	 * @throws IOException
	 */
	void repeat() throws IOException;
	
	 /** If the player has answered no to a question, work down the no side of the tree. 
	 * @throws IOException
	 */
	void tryNoSide() throws IOException;
	
	 /** If the player has answered yes to a question, work down the yes side of the tree.
	 * @throws IOException
	 */
	void tryYesSide() throws IOException;
	 
	 /** The name of the animal in this node ("error" for NullGame nodes)
	 * @return the animal name
	 */
	String animal();
	 
	 /** Play the game starting at the root node. Does initialization and then sends
	  * repeat to itself (the root). 
	 * @throws IOException
	 */
	void play() throws IOException;
	
}
