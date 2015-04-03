package com.bms.raf;

import java.awt.Color;

import kareltherobot.*;

public class FastRobot extends Robot {

	public FastRobot(int street, int avenue, Direction direction, int beepers,
			Color badge) {
		super(street, avenue, direction, beepers, badge);
	}
	
	public void teleport(int distance) {
		World.setDelay(0);
		for (int i=0; i<distance; i++) {
			this.move();
		}
		World.setDelay(RobotMoves.DELAY);
	}

}
