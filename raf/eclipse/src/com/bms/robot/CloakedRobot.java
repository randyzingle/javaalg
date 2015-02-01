package com.bms.robot;

import java.awt.Color;

import kareltherobot.*;

public class CloakedRobot extends Robot {

	public CloakedRobot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}
	
	public CloakedRobot(int street, int avenue, Direction direction, int beepers, Color color) {
		super(street, avenue, direction, beepers);
	}
	
	@Override
	public void move() {
		super.move();
		boolean ntb = this.nextToABeeper();
		if (ntb) {
			useCloak();
		}

	}
	
	private void useCloak() {
		if(this.isVisible()) {
			World.setDelay(0);
			// I'm visible so pick up a beeper
			this.pickBeeper();
			// and turn invisible
			this.setVisible(false);
			World.setDelay(RobotMoves.DELAY);
		} else {
			World.setDelay(0);
			// I'm already invisible so drop my beeper on this one
			this.putBeeper();
			// and turn visible again
			this.setVisible(true);
			World.setDelay(RobotMoves.DELAY);
		}
	}

}
