package animals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AnimalMain
{
	/** Continue a game of animals and save the results back to the disk.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		Game.prompt("Play?");

		try
		{
			String filename = "animals.txt";
			AnimalGame theGame = null;
			if(Game.getAffirmativeReply())
			{
				BufferedReader in = new BufferedReader(new FileReader(filename));
				theGame = Game.read(in); //new Game();
				theGame.play();
			}
			else
			{
				System.exit(0);
			}
			Game.prompt("Play again?");
			while (Game.getAffirmativeReply())
			{
				theGame.play(); //repeat();
				
				Game.prompt("Play again?");
				//Game.reset();
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			theGame.save(out);
			out.close();
		}
		catch (Exception ioe)
		{
			System.out.println("Exiting because " + ioe);
			ioe.printStackTrace();
			System.exit(1);
		}
	}

}
