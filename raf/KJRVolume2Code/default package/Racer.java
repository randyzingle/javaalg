import com.jbergin.robot.*;
import static com.jbergin.robot.Direction.*;


public class Racer extends KarelRobot
{
	public Racer(int street, int avenue, Direction direction, int beepers)
	{	super(street, avenue, direction, beepers);
	}
	
	public void turnRight(){
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void  raceStride() 
	{ 
		if ( frontIsClear() ) 
		{	move();
		}
		else 
		{	jumpHurdle();
		}
	}

	public void jumpHurdle() 
	{	jumpUp();
		move();
		glideDown();
	}
	
	public void jumpUp() 
	{	turnLeft();
		move();
		turnRight();
	}
	
	public void glideDown() 
	{	turnRight();
		move();
		turnLeft();
	}


	public static void main(String [] args){

		World world = KarelRobot.world();
		world.placeBeeper(1, 8);
		world.placeWallNorthSouth(1, 3);
		world.placeWallNorthSouth(1, 5);
		world.showWorld(1, 1, 5, 9);
		
		Racer karel = new Racer( 1, 1, East, 0);
		
		while( ! karel.nextToABeeper()){
			karel.raceStride();
		}
		karel.pickBeeper();
		karel.turnOff();
		world.showWorld(1, 1, 5, 9);
		karel.report();
		
	}
}

