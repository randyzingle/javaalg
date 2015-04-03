package com.bms.robot;

import java.awt.Color;

import kareltherobot.*;

public class RobotMoves1 extends RobotMoves {
	
	@Override
	public void makeWorld() {
		World.setSize(12, 12);
		World.readWorld("world/queens.kwld");
		World.setVisible(true);	
	}

	@Override
	public void moveRobots() {
		World.setDelay(0);	
		UberBot rafbot = new UberBot(4, 4, kareltherobot.Directions.East, 2, Color.black);
		UberBot gabebot = new UberBot(5, 5, kareltherobot.Directions.East, 8, Color.red);
		UrRobot simp = new UrRobot(1,1, kareltherobot.Directions.North, 0, Color.green);
		World.setDelay(DELAY);
		
		simp.turnLeft();
		simp.turnOff();
		
		rafbot.turnLeft();
		rafbot.moveTwo();
		rafbot.setVisible(false);
		
		gabebot.turnLeft();
		gabebot.move();
		
		rafbot.setVisible(true);
		rafbot.turnLeft();
		
		gabebot.turnLeft();
		
		rafbot.move();
		rafbot.turnLeft();
		rafbot.move();
		rafbot.turnOff();
			
		gabebot.turnLeft();
		gabebot.turnLeft();
		gabebot.teleport(DELAY, 2);
		gabebot.turnLeft();
		gabebot.moveTwo();
		gabebot.turnOff();
		
	}

}
