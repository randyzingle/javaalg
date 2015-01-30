
import java.io.IOException;

import com.jbergin.robot.*;
import static com.jbergin.robot.World.*;
import static com.jbergin.robot.Direction.*;

class SpiralStrategy implements Strategy 
{

    public SpiralStrategy(Strategy decorated)
	{   myDecorated = decorated;
    }
    public void doIt(Robot which)
	{
        myDecorated.doIt(which);
		which.putBeeper();
		if((which).frontIsClear())
		{	which.move();
		}
		else
		{	which.turnOff();
			which.report();
		}
    }

	private Strategy myDecorated = null;
}

public class SpiralWalker extends KarelRobot
{
    public SpiralWalker(int street, int avenue, Direction dir)
	{   super(street, avenue, dir, INFINITE);
	}

	public void walk()
	{   myStrategy.doIt(this);
		turnLeft();
		myStrategy = new SpiralStrategy(myStrategy);
		walk();
	}
	private Strategy myStrategy = new NullStrategy();

	public static void main(String [] args) throws IOException
	{   //World.setSize(20, 20);
		//World.setDelay(2);
		//World.setVisible(true);
		//World.setTrace(false);
		//WorldBuilder wb = new WorldBuilder(true);
		//World world = new World();
		SpiralWalker jonas = new SpiralWalker(5, 5, South);
		try {
			jonas.walk();
		} catch (RuntimeException e) {
			System.out.println(e);
			KarelRobot.world().writeWorld("spiral.kwld");
		}
	}

}
