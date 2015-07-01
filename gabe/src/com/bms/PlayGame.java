package com.bms;

import java.util.*;

public class PlayGame {

	public static void main(String[] args) {
		PlayGame pg = new PlayGame();
		pg.run();
	}
	
	public void run() {
		ArrayList list = new ArrayList();
		CharacterCreater cc = new CharacterCreater();
		Character c = cc.makeCharacter();
		Weapon w = new Weapon();
		w.name = "BIG Broad Sword";
		w.damage = 10;
		w.ndice = 2;
		w.bonus = 5;
		c.weapon = w;
		System.out.println(c);
		
		CombatUtilities.testWeapon(c.weapon, 10000);
		
//		for (int i = 0; i<10; i++) {
//			int damage = CombatUtilities.getDamage(c.weapon);
//			System.out.println("Damage: " + damage);
//		}
	}

}
