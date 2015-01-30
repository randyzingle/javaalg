package animals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game implements AnimalGame
{
	private static AnimalGame leaf = NullGame.leaf; 
	
	private static AnimalGame currentGame; // to remember the root
	
	private final String animal;
	private String question = null;
	private AnimalGame yesTarget = leaf;
	private AnimalGame noTarget = leaf;

	private static final TryStrategy noAsk = new NoAskStrategy(); // singletons
	private static final TryStrategy yesAsk = new YesAskStrategy();
	private static final TryStrategy noDown = new NoDownStrategy();
	private static final TryStrategy yesDown = new YesDownStrategy();

	private static AnimalGame rememberedAnimal = currentGame; //leaf;
	
	private TryStrategy yesStrategy = yesAsk;
	private TryStrategy noStrategy = noAsk;
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	
	public Game()
	{
		this.animal = "horse";
		this.question = "Is it bigger than you?";	
		//leaf = NullGame.leaf; 
		noTarget = leaf;
		yesTarget = leaf;
		currentGame = this;
	}
	
	private Game(String question, String animal)
	{
		this.question = question;
		this.animal = animal;
		noTarget = leaf;
		yesTarget = leaf;
	}
	
	public void save(BufferedWriter file) throws IOException
	{
		file.write("" + animal + " % " + question);
		file.newLine();
//		if(noTarget == null) System.out.println(animal);
//		if(leaf == null)
//		{ 
//			System.out.println("leaf is null");
//		}
		noTarget.save(file);
		yesTarget.save(file);
	}
	
	public String animal()
	{
		return animal;
	}
	
	private String question()
	{
//		if(question == null)
//		{
//			System.out.println("null question");
//			return "Are you thinking of a(n) " + animal + "?";
//		}
		return question;
	}
	
	private boolean endStateNo() // not used in the strategy version
	{
		return noTarget == leaf; 
	}
	
	private boolean endStateYes()
	{
		return yesTarget == leaf;
	}
	
	private static final class YesAskStrategy implements TryStrategy 
	{
		public void tryIt(Game game) throws IOException
		{
			game.yesTarget = game.askAboutAnimal(game);
			if(game.yesTarget != leaf)
			{
				game.yesStrategy = yesDown;
			}
		}
	}
	
	private static final class YesDownStrategy implements TryStrategy
	{
		public void tryIt(Game game) throws IOException
		{
			//game.goDownYes();
			rememberedAnimal = game;
			game.yesTarget.repeat();
		}
	}
	
	public void tryYesSide() throws IOException
	{
		yesStrategy.tryIt(this);
//		if(endStateYes())
//		{
//			yesTarget = askAboutAnimal(this);
//		}
//		else
//		{
//			//goDownYes();
//			rememberedAnimal = this;
//			yesTarget.repeat();
//		}
	}
	
	public void tryNoSide() throws IOException 
	{ 
		noStrategy.tryIt(this);
//		if(endStateNo())
//		{
//			noTarget = askAboutAnimal(rememberedAnimal);
//		}
//		else
//		{
//			//goDownNo();
//			noTarget.repeat();
//		}
	}
	
	private static final class NoAskStrategy implements TryStrategy 
	{
		public void tryIt(Game game) throws IOException
		{
			game.noTarget = game.askAboutAnimal(rememberedAnimal);
			if(game.noTarget != leaf)
			{
				game.noStrategy = noDown;
			}
		}
	}
	
	private static final class NoDownStrategy implements TryStrategy
	{
		public void tryIt(Game game) throws IOException
		{
			//game.goDownNo();
			game.noTarget.repeat();
		}
	}
	

//	public void goDownYes() throws IOException
//	{
//		rememberedAnimal = this;
//		yesTarget.repeat();
//	}
//	
//	public void goDownNo() throws IOException
//	{
//		noTarget.repeat();
//	}
	
	private AnimalGame askAboutAnimal(AnimalGame theAnimal) throws IOException
	{
		if(theAnimal == leaf)
		{
			return askForNewAnimal(theAnimal);
		}
		prompt("Were you thinking of a(n) " + theAnimal.animal() +"?");
		if(getAffirmativeReply())
		{
			// machine wins
			System.out.println("Machine wins.");
			return leaf; //null;
		}
		else
		{
			//user wins
			return askForNewAnimal(theAnimal);
		}
	}
	
	private AnimalGame askForNewAnimal(AnimalGame previous) throws IOException
	{
		System.out.println("I don't know that one. Congratulations.");
		prompt("What animal were you thinking of?");
		String animal = in.readLine();
		System.out.println("Please help me learn it.");
		String previousAnimal = "horse";
		if(previous != leaf)
		{
			previousAnimal = previous.animal();
		}
		System.out.println("Type in a question that distinguishes a(n) " + animal +
				" from a(n) " + previousAnimal);
		System.out.println(" The answer for a(n) "+ animal + " should be 'yes'.");
		String question = in.readLine();
		System.out.println("Thank you.\n");
		Game result = new Game(question, animal);
		return result;
	}
		
	
	static void reset()
	{
		rememberedAnimal = currentGame; //leaf;
	}
	
	public static final boolean getAffirmativeReply() throws IOException
	{
		String reply = in.readLine();
		if(reply == null || reply.equals(""))
		{
			return false;
		}
		char ans = reply.charAt(0);
		return ans == 'y' || ans == 'Y';
	}
	
	public static final void prompt(String prompt)
	{
		System.out.print(prompt + " ");
	}
	
	public void play() throws IOException
	{
		rememberedAnimal = currentGame; //leaf;
		System.out.println("Think of an animal.");
		prompt("OK?");
		in.readLine(); // ignore it
		repeat();
	}
	
	public void repeat() throws IOException
	{
		prompt(question());
		if (getAffirmativeReply())
		{
			tryYesSide();
		}
		else  // assume no
		{
			tryNoSide();
		}
	}
	
		
	public static final AnimalGame read(BufferedReader in) throws IOException
	{
		String aLine = in.readLine();
		if(aLine.equals("null"))
		{
			return leaf;
		}
		int first = aLine.indexOf("%");
		String animal = aLine.substring(0, first-1).trim();
		int last = aLine.lastIndexOf("%");
		String question = aLine.substring(last + 2).trim();
		Game result = new Game(question, animal);
		if(currentGame == null)
		{
			currentGame = result;
		}
		result.noTarget = read(in);
		if(result.noTarget != leaf)
		{
			result.noStrategy = noDown;
		}
		result.yesTarget = read(in);
		if(result.yesTarget != leaf)
		{
			result.yesStrategy = yesDown;
		}
		return result;
	}
		
}
