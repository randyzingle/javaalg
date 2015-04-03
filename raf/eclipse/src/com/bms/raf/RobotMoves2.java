package com.bms.raf;

import kareltherobot.Directions;
import kareltherobot.World;

public class RobotMoves2 extends RobotMoves {

	@Override
	public void makeWorld() {
		World.setSize(12, 12);
		World.setVisible(true);
		World.readWorld("world.kwld");
	}

	@Override
	public void moveRobots() {
		CloakBot fred = new CloakBot(4,1,Directions.East,3);
		for (int i=0; i<10; i++) {
			fred.move();
		}
		
	}

}
