package com.bms;

import java.util.ArrayList;

public class MainRunner {
	
	private ArrayList<Cat> catList = new ArrayList<Cat>();

	public static void main(String[] args) {
			
		MainRunner mr = new MainRunner();
		mr.run();
		mr.runThis();
	}
	
	private void run() {
		int n = 5;
		for (int i=0; i<n; i++) {
			Cat c = makeCat(i);
			
			if (i == 3) {
				c = catList.get(0);
				catList.add(c);
			} else {
				catList.add(c);
			}
		}
	}
	
	private void funky() {
		
	}
	
	private Cat makeCat(int cnumber) {
		Cat c = new Cat();
		System.out.println(c);
		c.setName("fluffy"+cnumber);
		c.setColor("color"+cnumber);
		return c;
	}
	
	private void runThis() {
		System.out.println("Whats up?");
		for (Cat c: catList) {
			System.out.println(c);
		}
	}

}
