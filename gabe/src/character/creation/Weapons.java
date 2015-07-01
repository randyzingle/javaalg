package character.creation;

import java.util.Random;

public class Weapons {
	Random rn = new Random();
	int random;
	int damage;
	boolean multiply;
	
	public int roleDamage(int weaponType) {
		if (weaponType == 1) {
			damage = longSword();
		} else if (weaponType == 2) {
			damage = greatSword();
		} else if (weaponType == 3) {
			damage = mace();
		} else if (weaponType == 4) {
			damage = dagger();
		} else if (weaponType == 5) {
			damage = quarterstaff();
		}
		return damage;
	}
	
	public int longSword() {
		random = rn.nextInt(8) + 1;
		multiply = criticalHit(20, 1, 19);
		if (multiply) {
			random *= 2;
		}
		return random;
	}
	public int greatSword() {
		random = rn.nextInt(11) + 2;
		multiply = criticalHit(20, 1, 19);
		if (multiply) {
			random *= 2;
		}
		return random;
	}
	public int mace() {
		random = rn.nextInt(6) + 1;
		multiply = criticalHit(20, 1, 20);
		if (multiply) {
			random *= 2;
		}
		return random;
	}
	public int dagger() {
		random = rn.nextInt(8) + 1; //Rogue has two 2d4 daggers
		multiply = criticalHit(20, 1, 20);
		if (multiply) {
			random *= 2;
		}
		return random;
	}
	public int quarterstaff() {
		random = rn.nextInt(6) + 1;
		multiply = criticalHit(20, 1, 20);
		if (multiply) {
			random *= 2;
		}
		return random;
	}
	
	public boolean criticalHit(int max, int min, int succeed) {
		boolean crit = false;
		int chance = rn.nextInt(max - min + 1) + min;
		if (chance >= succeed) {
			crit = true;
			System.out.println("You scored a Critical hit!");
		} else {
			
		}
		
		return crit;	
	}
}
