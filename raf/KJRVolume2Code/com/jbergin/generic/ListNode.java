package com.jbergin.generic;

public class ListNode<T>{
	private T value;
	private ListNode<T> next;
	
	public ListNode(T initialValue, ListNode<T> initialNext){
		value = initialValue;
		next = initialNext;
	}
	
	public T getValue(){
		return value;
	}
	
	public void setValue(T newValue){
		value = newValue;
	}

	public ListNode<T> getNext(){
		return next;
	}
	
	public void setNext(ListNode<T> newNextNode){
		next = newNextNode;
	}
}
