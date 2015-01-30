package com.jbergin.generic;

import java.util.Collection;
import java.util.Iterator;

public class DenseList<T> implements Iterable<T>, Collection<T>{
	
	private int size = 0;
	private int capacity;
	private T[] store = null;
	
	public DenseList(int initialCapacity){
		capacity = initialCapacity;
		store = (T[])new Object[capacity];
	}
	
	public DenseList(){
		this(1);
	}
	
	public void add(int index, T value){
		if(index < 0 || index > size){
//			System.out.println("index " + index + " size " +size);
			throw new IndexOutOfBoundsException();
		}				
		if(size == capacity){
			expand();
		}
		for(int i = size - 1; i>= index; --i){
			store[i + 1] = store[i];
		}
		size++;
		store[index] = value;
	}
	
	private void expand(){
		T[] newStore = (T[])new Object[2*capacity];
		for(int i = 0; i < size; ++i){
			newStore[i] = store[i];
		}
		store = newStore;
		capacity = 2 * capacity;
	}
	
	public void clear(){
		size = 0;
		store = (T[])new Object[1];
	}
	
	public boolean add(T value){
		if(size == capacity){
			expand();
		}
		size++;
		store[size-1] = value;
		return true;
	}
	
	private void indexCheck(int index){
		if(index < 0 || index >= size || size == 0){
			System.out.println("index " + index + " size " +size);
			throw new IndexOutOfBoundsException();
		}				
	}
	
	public T get(int index){
		indexCheck(index);
		return store[index];
	}
	
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			int nextToYield = 0;

			public boolean hasNext() {
				return nextToYield < size;
			}

			public T next() {
				T result = store[nextToYield];
				nextToYield++;
				return result;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	public T remove(int index){
		indexCheck(index);
		T result = store[index];
		for(int i = index; i < size-1; ++i){
			store[i] = store[i+1];
		}
		size--;
		return result;
	}
	
	public boolean remove(Object value){
		for(int i = 0; i < size; ++i)
			if(store[i].equals(value)){
				remove(i);
				return true;
			}
		return false;
	}
	
	public T set(int index, T value){
		indexCheck(index);
		T result = store[index];
		store[index] = value;
		return result;
	}
	
	public int size(){
		return size;
	}

	public boolean addAll(Collection<? extends T> c) {
		boolean changed = false;
		for(T value:c){
			boolean temp = add(value);
			if(temp){
				changed = true;
			}
		}
		return changed;
	}

	public boolean contains(Object o) {
		for(T value:this){
			if(value.equals(o)){
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		for(Object value:c){
			if(!contains(value)){
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for(Object value: c){
			boolean temp = remove(value);
			if(temp){
				changed = true;
			}
		}
		return changed;
	}

	public boolean retainAll(Collection<?> c) {
		boolean changed = false;
		DenseList<T> toRemove = new DenseList<T>();
		for(T value: this){
			if(!c.contains(value)){
				toRemove.add(value);
				changed = true;
			}
		}
		removeAll(toRemove);
		return changed;
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int count = 0;
		for(Object value: this){
			result[count] = value;
			count++;
		}
		return result;
	}

	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("toArray is beyond the scope of this discussion.");
	}

}
