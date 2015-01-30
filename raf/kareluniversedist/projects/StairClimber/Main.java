import kareltherobot.*;
import java.awt.Color;

public class Main implements Directions
{
    public static void task()
    {
        private StairClimber edmund = new StairClimber(1,1,East,0,Color.blue);
        edmund.climbStair();
        edmund.climbStair();
        edmund.climbStair();
        edmund.pickBeeper();
        edmund.turnOff();
    }
    
    public static void main(String [] args)
    {
        task();
    }
}
