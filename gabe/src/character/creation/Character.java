package character.creation;

public class Character {
	
	private int strength;
	private int intelligence;
	private int agility;
	private int wisdom;
	private int constitution;
	private int hitPoints;
	private int conMod;
	private int baseHP;
	private int attackBonus;
	private int armorClass;
	private int experience = 0;
	private int armor;
	private int weapon;
	private int shield;
	private String name;
	private String characterClass;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacterClass() {
		System.out.println("Your class is called: " + characterClass + ".");
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
		System.out.println("setCharacterClass is now set to: " + characterClass + ".");
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getExperiencePoints() {
		return experience;
	}
	public void setExperiencePoints(int experience) {
		this.experience = experience;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitsPoints) {
		this.hitPoints = hP();
		
	}
	
	public int hP() {
		conMod = (getConstitution() - 10) / 2;
		if (getCharacterClass() == "1") {
			baseHP = 10;
		} else if (getCharacterClass() == "2") {
			baseHP = 6;
		} else if (getCharacterClass() == "3") {
			baseHP = 4;
		} else if (getCharacterClass() == "4") {
			baseHP = 8;
		}
		hitPoints = conMod + baseHP;
		return hitPoints;
		
	}
	
	public int getAttackBonues() {
		return attackBonus;
	} 
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = aB();
	}
	
	public int aB() {
		attackBonus = (getStrength() - 10) / 2;
		return attackBonus;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	public void setArmorClass(int armorClass) {
		this.armorClass = aC();
	}
	
	public int aC() {
		armorClass = ((getAgility() - 10) / 2) + 10;
		return armorClass;
	}
	
	public int getWeapon() {
		return weapon;
	}
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String toString() {
		return "Character [strength=" + strength + ", intelligence="
				+ intelligence + ", agility=" + agility + ", wisdom=" + wisdom
				+ ", constitution=" + constitution + ", hitPoints=" + hitPoints
				+ ", conMod=" + conMod + ", baseHP=" + baseHP
				+ ", attackBonus=" + attackBonus + ", armorClass=" + armorClass
				+ ", experience=" + experience + ", armor=" + armor
				+ ", weapon=" + weapon + ", shield=" + shield + ", name="
				+ name + ", characterClass=" + characterClass + "]";
	}
	

}
