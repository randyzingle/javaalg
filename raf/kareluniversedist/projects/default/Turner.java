import kareltherobot.*;
import java.awt.Color;

public class Turner extends UrRobot implements Directions
{
    
    public Turner(int street, int avenue, Directions.Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    
    
    public void turnAround()
    {
        this.move();
        this.move();
    }
    
}
