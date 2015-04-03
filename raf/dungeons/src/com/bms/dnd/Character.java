package com.bms.dnd;

public class Character {
	
	private int strength;
	private int intelligence;
	private int dexterity;
	private int constitiution;
	private int wisdom;
	private int charisma;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character(){
		this("Baldur Dog", 10, 10, 10, 10, 10, 10);
	}
	
	public Character(String name, int strength, int intelligence, int dexterity, 
			int constitution, int wisdom, int charisma){
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.constitiution = constitution;
		this.wisdom = wisdom;
		this.charisma = charisma;
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
	
	@Override
	public String toString(){
		String s = null;
		s = String.format("%s: Str %d, Int %d, Wis %d, Dex %d, Con %d, Cha %d",
				this.name, this.strength, this.intelligence, this.wisdom, this.dexterity,
				this.constitiution, this.charisma);
		return s;
	}

}
