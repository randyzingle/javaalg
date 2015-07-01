package com.bms;

import java.util.Random;

public class CombatUtilities {
	
	public static int getDamage(Weapon w) {
		int d = 0;
		Random r = new Random();
		for (int i=1; i<=w.ndice; i++) {
			d = d + r.nextInt(w.damage) + 1;
		}
		d = d + w.bonus;
		return d;
	}
	
	public static void testWeapon(Weapon w, int testSize) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int d = 0;
		for (int i=0; i<testSize; i++) {
			d = getDamage(w);
			if (d > max) max = d;
			if (d < min) min = d;
		}
		System.out.println("Max="+max+" : Min=" + min);
	}

}
