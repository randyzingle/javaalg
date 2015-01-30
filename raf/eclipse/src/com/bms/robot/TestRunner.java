package com.bms.robot;

import java.awt.Color;

import kareltherobot.*;

public class TestRunner  {
	
	public static void main(String[] args) {
		TestRunner tr = new TestRunner();
		tr.run();
	}

	public void run() {
		World.setSize(8, 8);
		World.setDelay(40);
		World.readWorld("queens.kwld");
		World.setVisible(true);
		
		UberBot rafbot = new UberBot(4, 4, kareltherobot.Directions.East, 0, Color.black);
		UberBot gabebot = new UberBot(5, 5, kareltherobot.Directions.East, 0, Color.red);
		
		rafbot.turnLeft();
		rafbot.move();
		
		gabebot.turnLeft();
		gabebot.move();
		
		rafbot.turnLeft();
		
		gabebot.turnLeft();
		
		rafbot.move();
		rafbot.turnLeft();
		rafbot.move();
		rafbot.turnOff();
			
		gabebot.turnLeft();
		gabebot.turnLeft();
		gabebot.move();
		gabebot.move();
		gabebot.move();
		gabebot.turnOff();

	}

}
