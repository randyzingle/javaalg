package com.jbergin.robot;

public class Driver {

	public static void findPut(UrSpecification robot){
//		if(robot.nextToABeeper()){
//			robot.pickBeeper();
//			robot.turnLeft();
//		}else{
			robot.move();
			findPut(robot);
			robot.move();
			robot.putBeeper();
		}
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		World world = new World();
		world.placeBeeper(10, 0);
		world.placeWallEastWest(4, 1);
		UrSpecification robot = new MiniKarel("Charlie", World.INFINITE, world);
		
		findPut(robot);
		robot.report();

	}

}
