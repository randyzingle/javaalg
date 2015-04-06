package com.bms.dnd;

public class DungeonRunner {

	public static void main(String[] args) {

		DungeonRunner dr = new DungeonRunner();
//		dr.makeCharacter();
		dr.testDice();

	}
	
	public void makeCharacter() {
		Character c = new Character();
//		c.setName("Baldur");
		c.setCharisma(20);
		System.out.println(c);
	}
	
	public void testDice() {
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i=0; i<100; i++) {
			int n = DndUtils.rollDice(6, 3);
			if (n > max) max = n;
			System.out.println(n);
		}
		System.out.println("max: " + max);
	}

}
