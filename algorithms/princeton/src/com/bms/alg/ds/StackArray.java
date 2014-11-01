package com.bms.alg.ds;

public class StackArray<Item> {
	
	private int cnt = 0;
	private Item[] items;
	
	public StackArray() {
		// start with a default stack size of 10
		this(10);
	}
	
	public StackArray(int initCapacity) {
		items = (Item[])new Object[initCapacity];
	}
	
	public void push(Item item) {
		// push
	}
	
	public Item pop() {
		Item i = null;
		return i;
	}

	public boolean isEmpty() {
		return cnt == 0;
	}
}
