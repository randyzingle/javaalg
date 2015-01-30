package com.jbergin.robot;

/** Allows an implementing robot class to make assertions about the 
 * state of "this" robot. Used primarily in JUnit testing, but applicable
 * elsewhere
 * @author jbergin
 *
 */
public interface Assertion {
	/** Assert that the robot is on a given street
	 * @param street the street in question
	 * @throws RobotException if the robot is not on that street
	 */
	public void assertOnStreet(int street) throws RobotException;
	
	/** Assert that a robot is on a given avenue
	 * @param avenue the avenue in question
	 * @throws RobotException if the robot is not on that avenue
	 */
	public void assertOnAvenue(int avenue) throws RobotException;
	
	/** Assert that a robot has no beepers in its beeper bag
	 * @throws RobotException if the robot has any beepers in its beeper bag
	 */
	public void assertHasNoBeepers() throws RobotException;
	
	/** Assert that a robot has some beepers in its beeper bag
	 * @throws RobotException if there are no beepers in its beeper bag
	 */
	public void assertHasBeepers() throws RobotException;
	
	/** Assert that the robot's front is clear
	 * @throws RobotException if the front is blocked
	 */
	public void assertFrontIsClear() throws RobotException;
	
	/** Assert that the robot is facing North
	 * @throws RobotException if the robot is facing any other direction
	 */
	public void assertFacingNorth() throws RobotException;
	
	/** Assert that the robot is facing West
	 * @throws RobotException if the robot is facing any other direction
	 */
	public void assertFacingWest() throws RobotException;
	
	/** Assert that the robot is facing South
	 * @throws RobotException if the robot is facing any other direction
	 */
	public void assertFacingSouth() throws RobotException;
	
	/** Assert that the robot is facing East
	 * @throws RobotException if the robot is facing any other direction
	 */
	public void assertFacingEast() throws RobotException;
	
	// more might be helpful
}
