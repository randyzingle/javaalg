package com.jbergin.robot;

import static com.jbergin.robot.Direction.*;

/** A robot that has sensing capabilities in addition to the Ur spec. 
 * @author jbergin
 *
 */
public class MiniRobot extends MiniKarel implements RobotSpecification {

	public MiniRobot(String name, int street, int avenue, Direction direction,
			int beepers, World world) {
		super(name, street, avenue, direction, beepers, world);
	}
	
	public MiniRobot(String name, int beepers, World world){
		super(name, beepers, world);
	}
	

	public boolean anyBeepersInBeeperBag() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}
	
	public boolean nextToABeeper() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}

	public boolean facingEast() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}

	public boolean facingNorth() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}

	public boolean facingSouth() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}

	public boolean facingWest() {
		RobotState state = getCurrentState();
		// TODO finish this
		return false;
	}

	public boolean frontIsClear() {
		return super.frontIsClear();
	}
	
}
