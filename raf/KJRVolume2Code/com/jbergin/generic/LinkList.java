package com.jbergin.generic;

import java.util.Collection;
import java.util.Iterator;

public class LinkList<T> implements Iterable<T>, Collection<T>{
	private ListNode<T> head = null;
	private int size = 0;
	
	public void clear(){
		head = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean add(T value){
		ListNode<T> node = head;
		if (node == null){
			head = new ListNode<T>(value, head);
			size++;
			return true;
		}
		ListNode<T> listNode = node;
		while (listNode.getNext() != null){
			listNode = listNode.getNext();
		}
		listNode.setNext(new ListNode<T>(value, null));
		size++;
		return true;
	}
	
	private void indexCheck(int index){
		if(index < 0 || index >= size || size == 0){
			throw new IndexOutOfBoundsException();
		}		
	}
	
	public T get(int index){
		indexCheck(index);
		T result = null;
		ListNode<T> listNode = head;
		for(int i = 0; i < index; ++i){
			listNode = listNode.getNext();
		}
		result = listNode.getValue();
		return result;		
	}
	
	public void add(int index, T value){
		indexCheck(index);
		if(index == 0){
			head = new ListNode<T>(value, head);
			size++;
			return;
		}
		ListNode<T> listNode = head;
		for(int i = 0; i < index-1; ++i){
			listNode = listNode.getNext();
		}
		listNode.setNext(new ListNode<T>(value, listNode.getNext()));
		size++;
	}
	
	public T set(int index, T value){
		indexCheck(index);
		T result = null;
		ListNode<T> listNode = head;
		for(int i = 0; i < index; ++i){
			listNode = listNode.getNext();
		}
		result = listNode.getValue();
		listNode.setValue(value);
		return result;
	}
	
	public boolean remove(Object value){
		ListNode<T> aNode = head;
		if(aNode == null){
			return false;
		}
		ListNode<T> listNode = aNode;
		if(listNode.getValue().equals(value)){
			head = listNode.getNext();
			size--;
			return true;
		}
		while(listNode.getNext() != null){
			ListNode<T> nextNode = listNode.getNext();
			if(nextNode.getValue().equals(value)){
				listNode.setNext(nextNode.getNext());
				size--;
				return true;
			}
			if(nextNode.getNext() == null){
				return false;
			}
			listNode = nextNode;
		}
		return false;
	}
	
	public T remove(int index){
		T result = null;
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		if(size == 0){
			return null;
		}
		ListNode<T> listNode = head;
		if(index == 0){
			size--;
			head = listNode.getNext();
			return listNode.getValue();
		}
		for(int i = 0; i < index - 1; ++i){
			listNode = listNode.getNext();
		}
		ListNode<T> nextNode = listNode.getNext();
		result = nextNode.getValue();
		listNode.setNext(nextNode.getNext());
		size--;
		return result;
	}
	
	public ModifyingIterator<T> iterator(){
		return new ModifyingIterator<T>(){
			
			private ListNode<T> nextToYield = head;
			private ListNode<T> previous = head;
			private boolean okToRemove = false;

			public boolean hasNext() {
				return nextToYield != null;

			}

			public T next() {
				if(nextToYield != head && previous.getNext() != nextToYield){
					previous = previous.getNext();
				}
				T result = nextToYield.getValue();
				nextToYield = nextToYield.getNext();
				okToRemove = true;
				return result;
				
			}

			public void remove() {
				if(!okToRemove){
					throw new IllegalStateException("Iterator illegal state to remove.");
				}
				okToRemove = false;
				if(previous == null){
					return;
				}
				if(previous == head && nextToYield == previous.getNext()){
					previous = head = nextToYield;
					size--;
					return;
				}
				ListNode<T> node = nextToYield;
				previous.setNext(node);
				size--;
			}
			
			public void set(T element) {
				if(previous.getNext() == nextToYield){
					previous.setValue(element);
				}
				else{
					previous.getNext().setValue(element);
				}
			}
			
			public void add(T element){
				if(previous == nextToYield){
					head = previous = nextToYield = new ListNode<T>(element, head);
				}
				else if(previous.getNext() == nextToYield){
					previous.setNext(new ListNode<T>(element, nextToYield));
				}
				else{
					previous = previous.getNext();
					previous.setNext(new ListNode<T>(element, nextToYield));
				}
				size++;
			}
		};
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
