import kareltherobot.*;
import java.awt.Color;

public class StairClimber extends UrRobot implements Directions
{
    
    public StairClimber(int street, int avenue, Directions.Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    
    
    public void turnRight()
    {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }
    
    public void climbStair()
    {
        this.turnLeft();
        this.move();
        this.turnRight();
        this.move();
    }
    
}
