package com.bms;

public class Weapon {
	public String name;
	public int damage;
	public int ndice = 1;
	public int bonus = 0;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weapon [name=");
		builder.append(name);
		builder.append(", damage=");
		builder.append(damage);
		builder.append("]");
		return builder.toString();
	}
}
