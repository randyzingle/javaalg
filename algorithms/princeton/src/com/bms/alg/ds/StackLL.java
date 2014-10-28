package com.bms.alg.ds;

import java.util.Iterator;

public class StackLL<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	private int size;

	public static void main(String[] args) {
		StackLL<Integer> ss = new StackLL<Integer>();
		for (int i=0; i<10; i++) {
			ss.push(i);
		}
		Integer it = null;
		while ( (it = ss.pop()) != null) {
			System.out.println(it);
		}
	}
	
	public void push(Item it) {
		size++;
		if(first == null) {
			first = new Node<Item>();
			first.it = it;
		} else {
			Node<Item> oldFirst = first;
			first = new Node<Item>();
			first.it = it;
			first.next = oldFirst;
		}
	}
	
	public Item pop() {
		// for now return null if the stack is empty
		if (first == null) {
			return null;
		} else {
			size--;
			Item it = first.it;
			first = first.next;
			return it;
		}
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	private class Node<Item> {
		Node<Item> next;
		Item it;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class StackIterator<Item> implements Iterator<Item> {	
		@Override
		public boolean hasNext() {
			if (first != null) {
				return true;
			}
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
