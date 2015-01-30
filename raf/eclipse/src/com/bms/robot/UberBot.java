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

}
