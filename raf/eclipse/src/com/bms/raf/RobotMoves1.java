package com.bms.raf;

import kareltherobot.Directions;
import kareltherobot.World;
import java.awt.*;

public class RobotMoves1 extends RobotMoves {

	@Override
	public void makeWorld() {
		World.setSize(12, 12);
		World.setVisible(true);
	}

	@Override
	public void moveRobots() {
		FastRobot fr = new FastRobot(2,2,Directions.East, 3, Color.RED);
		fr.move();
		fr.putBeeper();
		fr.move();
		fr.putBeeper();
		fr.move();
		fr.putBeeper();
		fr.move();
		fr.move();
		fr.turnOff();
		
	}

}
