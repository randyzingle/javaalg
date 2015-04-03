package com.bms.raf;

import kareltherobot.Robot;

public class CloakBot extends Robot {

	public CloakBot(int street, int avenue, Direction direction, int beepers) {
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
		
	public void useCloak () {
		if (this.isVisible()){
			this.pickBeeper();
			this.setVisible(false);			
		} else {
			this.putBeeper();
			this.setVisible(true);
		}
	}

}
