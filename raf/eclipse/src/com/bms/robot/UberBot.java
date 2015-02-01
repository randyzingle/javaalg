package com.bms.robot;

import kareltherobot.*;

import java.awt.Color;

public class UberBot extends UrRobot {

	public UberBot(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}
	
	public UberBot(int street, int avenue, Direction direction, int beepers, Color color) {
		super(street, avenue, direction, beepers, color);
	}
	
	public void moveTwo() {
		this.move();
		this.move();
	}
	
	public void teleport(int delay, int distance) {
		World.setDelay(0);
		this.setVisible(false);
		for (int i=0; i<distance; i++) {
			this.move();
			this.putBeeper();
		}
		this.setVisible(true);
		World.setDelay(delay);
	}

}
