package com.jbergin.robot;

/** Specifies the sensing capabilities of simple robots
 * @author jbergin
 *
 */
public interface RobotSpecification extends UrSpecification {

	/** Return true if the robot is facing North
	 * @return true if the robot is facing North
	 */
	public boolean facingNorth();
	
	/** Return true if the robot is facing West
	 * @return true if the robot is facing West
	 */
	public boolean facingWest();
	
	/** Return true if the robot is facing South
	 * @return true if the robot is facing South
	 */
	public boolean facingSouth();
	
	/** Return true if the robot is facing East
	 * @return true if the robot is facing East
	 */
	public boolean facingEast();
	
	/** Returns true if there is a beeper on the robot's current corner
	 * @return true if there is a beeper on the robot's current corner
	 */
	public boolean nextToABeeper();
	
	/** Returns true if there are any beepers in the robot's beeper bag
	 * @return true if there are any beepers in the robot's beeper bag
	 */
	public boolean anyBeepersInBeeperBag();
	
	/** Return true if there is no wall immediately in front of the robot
	 * @return true if there is no wall immediately in front of the robot
	 */
	public boolean frontIsClear();
}
