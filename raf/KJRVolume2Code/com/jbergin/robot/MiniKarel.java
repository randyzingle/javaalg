package com.jbergin.robot;

import static com.jbergin.robot.Direction.*;

/** The simplest kind of robot. A minimal implementation of UrSpecification
 * @author jbergin
 *
 */
public class MiniKarel implements UrSpecification {

	private String name = null;
	private World myWorld = null;
	private int currentStreet = 1;
	private int currentAvenue = 1;
	private Direction direction = North; 
	private boolean onState = true;
	private int beepers = 0;

	/** Create a robot at the origin, facing North
	 * @param name A name for the robot to be used in reports
	 * @param beepers the number of beepers in the beeper bag initially
	 * @param world the world that this robot will be delivered to
	 */
	public MiniKarel(String name, int beepers, World world){
		this(name, 1, 1, North, beepers, world);
	}
	/* Notes. Use -1 (or World.INFINITE) to represent an infinity of beepers
	 * By default the robot starts at street 1, avenue 1, facing North. 
	 */
	
	/** Create a robot is an arbitrary situation
	 * @param name A name for the robot to be used in reports
	 * @param street the initial street
	 * @param avenue the initial avenue
	 * @param direction the initial Direction North, South, East, or West
	 * @param beepers the number of beepers in the beeper bag initially
	 * @param world the world that this robot will be delivered to
	 */
	public MiniKarel(String name, int street, int avenue, Direction direction, int beepers, World world){
		this.name  = name;
		this.currentStreet = street;
		this.currentAvenue = avenue;
		this.direction = direction;
		this.beepers = beepers;
		this.myWorld = world;
		report();	
	}
	
	public void move() {
		if(!onState){
			throw new RobotException(name + " tried to move when not running.");
		}
		if(! frontIsClear()){
			onState = false;
			report();
			throw new RobotException(name + " tried to walk through a wall.");
		}
		System.out.println(name + " moved.");
		if(direction == North){
			currentStreet++;
		}
		else if (direction == West){
			currentAvenue--;
		}
		else if(direction == East){
			currentAvenue--;
		}
		else{ // South
			currentStreet--;
		}
	}

	public void turnLeft() {
		if(!onState){
			throw new RobotException(name + " tried to turn left when not running.");
		}
		System.out.println(name + " turned left.");
		if(direction == North){
			direction = West;
		}
		else if (direction == West){
			direction = South;
		}
		else if(direction == East){
			direction = North;
		}
		else{ // South
			direction = East;
		}
	}

	public void turnOff() {
		System.out.println(name + " turned off.");
		onState = false;
	}


	public void pickBeeper() {
		if(!onState){
			throw new RobotException(name + " tried to pickBeeper when not running.");
		}
		if(myWorld.hasBeeper(currentStreet, currentAvenue)){
			// TODO finish this
		}
		else{
			// TODO finish this
		}
	}

	public void putBeeper() {
		if(!onState){
			throw new RobotException(name + " tried to putBeeper when not running.");
		}
		// TODO finish this
	}

	public void report() {
		String beepersCount = beepers<0?"infinite": new Integer(beepers).toString();
		String clearState = frontIsClear()?"clear.":"blocked.";
		String runningState = onState?"running.":"halted.";
		System.out.println(name + " is facing " + direction +
				" at row " + currentStreet + " column " + currentAvenue + " with " + beepersCount + " beepers. "
				+ " Front is " + clearState + " Run state is " + runningState);
	}

	/** Package visible method to determine if the robot's front is clear
	 * @return true if the front is clear
	 */
	boolean frontIsClear() {
		return direction == North && ! myWorld.wallOnAvenueNorthOf(currentStreet, currentAvenue)
		|| direction == South && ! myWorld.wallOnAvenueSouthOf(currentAvenue, currentStreet)
		|| direction == East && ! myWorld.wallOnStreetEastOf(currentStreet, currentAvenue)
		|| direction == West && ! myWorld.wallOnStreetWestOf(currentStreet, currentAvenue);
	}
	
	/** Package visible snapshot of the robot's state then this object was created
	 * @author jbergin
	 *
	 */
	class RobotState{
		// TODO finish this
	}
	
	/** Obtain a snapshot of the robot's state when this is invoked
	 * @return the robot's instantaneous state - a snapshot
	 */
	RobotState getCurrentState(){
		// TODO finish this
		return null;
	}

}
