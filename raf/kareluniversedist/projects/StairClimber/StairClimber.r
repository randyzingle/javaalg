
class StairClimber extends UrRobot
{
    StairClimber()
    {
    }
    
    
    
    void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    void climbStair()
    {
        turnLeft();
        move();
        turnRight();
        move();
    }
}