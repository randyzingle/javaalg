package com.bms.robot;

import java.awt.*;

import kareltherobot.*;

public class RobotMoves2 extends RobotMoves {
	
	@Override
	public void makeWorld() {
		World.setSize(12, 12);
		World.readWorld("world/world.kwld");
		World.setVisible(true);	
	}

	@Override
	public void moveRobots() {
		CloakedRobot rafbot = new CloakedRobot(4, 1, kareltherobot.Directions.East, 0, Color.black);
		for (int i=0; i<10; i++) {
			rafbot.move();
		}
	}



}
