package com.bms.robot;

import kareltherobot.*;

public class TestRunner  {
	
	public static void main(String[] args) {
		TestRunner tr = new TestRunner();
		tr.run();
		RobotMoves rm = new RobotMoves1();
		rm.moveRobots();
	}

	public void run() {
		World.setSize(12, 12);
		World.readWorld("world.kwld");
		World.setVisible(true);
	}

}
