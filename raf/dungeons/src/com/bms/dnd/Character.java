package com.bms.dnd;

public class Character {
	
	private int strength;
	private int intelligence;
	private int dexterity;
	private int constitiution;
	private int wisdom;
	private int charisma;
	
	public Character(){
		//Default Constructor
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
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitiution() {
		return constitiution;
	}
	public void setConstitiution(int constitiution) {
		this.constitiution = constitiution;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

}
