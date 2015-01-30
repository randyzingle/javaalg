package com.jbergin.robot;

/** Defaines the basic capabilities of a simple robot
 * @author jbergin
 *
 */
public interface UrSpecification {
	/** Robot moves forward one block or halts and turns off
	 *  if its front is blocked, , signaling an error
	 */
	public void move();
	
	/** Robot turns 90 degrees to its left
	 */
	public void turnLeft();
	
	/** Robot turns off. If later sent any message except another
	 * turnOff message, it will throw a RobotException
	 */
	public void turnOff();
	
	/** Robot picks one beeper from the current corner if any
	 * are available. If not, it turns off, signaling an error.
	 */
	public void pickBeeper();
	
	/** Robot puts one beeper on the current corner if it has any
	 * in its beeper-bag. If not, it turns off, signaling an error.
	 */
	public void putBeeper();
	
	/** Robot prints its current state to System.out
	 */
	public void report();
}
