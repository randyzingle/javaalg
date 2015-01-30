package com.jbergin.generic;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {

	BinaryTreeSet<Integer> tree;
//	HashTable<Integer> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BinaryTreeSet<Integer>();
//		tree = new HashTable<Integer>(5);

	}
	

	@Test
	public void testBinaryTreeSet() {
		assertEquals(0, tree.size());
	}

	@Test
	public void testBinaryTreeSetComparatorOfT() {
		Comparator<Integer> comp = new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
			
		};
		tree = new BinaryTreeSet<Integer>(comp);
		addMany();
		System.out.println("reverse");
		for(Integer v: tree){
			System.out.println(v);
		}
		System.out.println("end reverse");

	}

	@Test
	public void testIterator() {
		addMany();
		Iterator<Integer> iter = tree.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	@Test
	public void testAdd() {
		assertTrue(tree.add(5));
		assertTrue(tree.contains(5));
		assertEquals(1, tree.size());
		tree.remove(5);
		assertFalse(tree.contains(5));
		assertEquals(0, tree.size());
		tree.add(3);
		tree.add(5);
		assertTrue(tree.contains(5));
		assertEquals(2, tree.size());
		tree.remove(5);
		assertFalse(tree.contains(5));
		assertEquals(1, tree.size());
	}

	@Test
	public void testAddAll() {
		DenseList<Integer> list = new DenseList<Integer>();
		list.add(5);
		list.add(9);
		list.add(3);
		list.add(7);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(1);
		tree.addAll(list);
		assertEquals(6, tree.size());		
	}
	
	private void addMany(){
		tree.add(new Integer(5));
		tree.add(3);
		tree.add(4);
		tree.add(7);		
	}

	@Test
	public void testClear() {
		addMany();
		tree.clear();
		assertEquals(0, tree.size());
	}

	@Test
	public void testContains() {
		addMany();
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(5));
		assertFalse(tree.contains(9));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tree.isEmpty());
		tree.add(5);
		assertFalse(tree.isEmpty());
		tree.remove(5);
		assertTrue(tree.isEmpty());
	}

	@Test
	public void testRemove() {
		addMany();
		assertTrue(tree.remove(3));
		assertTrue(tree.contains(5));
		assertFalse(tree.contains(3));
	}
	@Test
	public void testRemoveRoot() {
		addMany();
		assertTrue(tree.remove(5));
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(5));
	}
	@Test
	public void testRemoveMissing() {
		addMany();
		assertFalse(tree.remove(15));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(5));
	}


	@Test
	public void testRemoveAll() {
		DenseList<Integer> list = new DenseList<Integer>();
		list.add(5);
		list.add(9);
		list.add(3);
		addMany();
		assertTrue(tree.removeAll(list));
		assertEquals(2, tree.size());
		assertTrue(tree.contains(4));
		assertFalse(tree.contains(3));
	}

	@Test
	public void testRetainAll() {
//		System.out.println("test retain all");
		DenseList<Integer> list = new DenseList<Integer>();
		list.add(5);
		list.add(9);
		list.add(3);
		addMany();
		assertTrue(tree.retainAll(list));
		assertEquals(2, tree.size());
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(4));
	}

	@Test
	public void testSize() {
		addMany();
		assertEquals(4, tree.size());
	}

}
