package com.jbergin.generic;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ListTest {

	private LinkList<Integer> list;
//	private DenseList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkList<Integer>();
//		list = new DenseList<Integer>();
	}
	
	@Test
	public void testEmptyOnCreation(){
		assertEquals(0, list.size());
	}
	
	@Test
	public void testAdd(){
		list.add(3);
		assertEquals(1, list.size());
		list.add(5);
		assertEquals(2, list.size());
	}
	
	public void addMany(){
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
	}
	
	@Test
	public void testIteratorAdd(){
		System.out.println("Iterator add");
		addMany();
		ModifyingIterator<Integer>iter = list.iterator();
		while(iter.hasNext()){
			Integer item = iter.next();
			if(item== 5 || item == 2)
				iter.add(item + 10);
		}
		for(int x:list){
			System.out.println("remains " + x);
		}
		assertTrue(list.contains(15));
		assertTrue(list.contains(12));
		assertEquals(6, list.size());
			
	}
	
	@Test 
	public void testIteratorSet(){
		System.out.println("Iterator set");
		addMany();
		ModifyingIterator<Integer>iter = list.iterator();
		while(iter.hasNext()){
			int item = iter.next();
			if(item== 5 || item == 3)
				iter.set(item + 10);
		}
		for(int x:list){
			System.out.println("remains " + x);
		}
		assertTrue(list.contains(15));
		assertTrue(list.contains(13));
		assertEquals(4, list.size());
	}
	
	@Test
	public void testIteratorRemove(){
		System.out.println("Iterator remove");
		addMany();
		int value = 5;
		Iterator<Integer>iter = list.iterator();
		
		while(iter.hasNext()){
			Integer item = iter.next();
			if(item.equals(value) || item.equals(value - 1)){
				iter.remove();
			}
		}
		for(int x:list){
			System.out.println("remains " + x);
		}
		assertEquals(2, list.size());
		assertFalse(list.contains(value));
	}
	
	@Test
	public void testIterator(){
		addMany();
		System.out.println("iterating");
		for(Object o: list){
			System.out.println(o.toString());
		}
	}
	
	public void dump(String message){
		System.out.println(message);
		for(Object o: list){
			System.out.println(o.toString());
		}
	}
	
	@Test
	public void testRemove(){
		addMany();
		Integer  toRemove= new Integer(5);
		assertEquals(true, list.remove(toRemove));
		assertEquals(3, list.size());
		dump("removing");
	}
	
	@Test
	public void testGet(){
		addMany();
		assertEquals(5, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(2, list.get(3));
		
	}
	
	@Test
	public void testSet(){
		addMany();
		list.set(2, 7);
		assertEquals(7, list.get(2));
		dump("setting 7");
	}
	
	@Test
	public void testClear(){
			addMany();
			list.clear();
			assertEquals(0, list.size());
	}
	
	@Test
	public void testRemoveIndex3(){
		addMany();
		Integer removed = list.remove(3);
		assertEquals(3, list.size());
		assertEquals(2, removed);
		dump("removing index 3");
	}
	@Test
	public void testRemoveIndex2(){
		addMany();
		Integer removed = list.remove(2);
		assertEquals(3, list.size());
		assertEquals(3, removed);
		dump("removing index 2");
	}
	@Test
	public void testAddAt(){
		addMany();
		list.add(2, 6);
		assertEquals(6, list.get(2));
		assertEquals(3, list.get(3));
		assertEquals(5, list.size());
		list.add(0, 9);
		dump("addAt");
		assertEquals(9, list.get(0));
		assertEquals(6, list.get(3));
		assertEquals(6, list.size());
		
	}
	
	@Test
	public void testRemoveIndex0(){
		addMany();
		Integer removed = list.remove(0);
		assertEquals(3, list.size());
		assertEquals(5, removed);
		dump("removing index 0");
	}
}
