package com.bms.raf;

public class TestRunner  {
	
	public static void main(String[] args) {
		RobotMoves rm = new RobotMoves2();
		rm.makeWorld();
		rm.moveRobots();
	}

}