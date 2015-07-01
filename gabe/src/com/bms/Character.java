package com.bms;

public class Character {

	private String name;
	private String cclass;
	private int level;
	
	public Weapon weapon;
	
	public Character() {}
	
	public Character(String name, String cclass, int level) {
		this.name = name;
		this.cclass = cclass;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCclass() {
		return cclass;
	}
	public void setCclass(String cclass) {
		this.cclass = cclass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Character [name=");
		builder.append(name);
		builder.append(", cclass=");
		builder.append(cclass);
		builder.append(", level=");
		builder.append(level);
		builder.append(", weapon=");
		builder.append(weapon);
		builder.append("]");
		return builder.toString();
	}
	
}
