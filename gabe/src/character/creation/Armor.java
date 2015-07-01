package character.creation;

public class Armor {
	
	int armorClass;
	
	public int heavyArmor(int dexBonus, int enchant) {
		if (dexBonus > 2) {
			dexBonus = 2;
		}
		armorClass = 6 + dexBonus + enchant;
		return armorClass;
	}
	
	public int mediumArmor(int dexBonus, int enchant) {
		if (dexBonus > 4) {
			dexBonus = 4;
		}
		armorClass = 4 + dexBonus + enchant;
		return armorClass;
	}
	
	public int lightArmor(int dexBonus, int enchant) {
		if (dexBonus > 6) {
			dexBonus = 6;
		}
		armorClass = 2 + dexBonus + enchant;
		return armorClass;
	}
	
	public int clothArmor(int dexBonus, int enchant) {
		armorClass = 0 + dexBonus + enchant;
		return armorClass;
	}
	
	public int shield(int enchant) {
		armorClass = 3 + enchant;
		return armorClass;
	}

}
