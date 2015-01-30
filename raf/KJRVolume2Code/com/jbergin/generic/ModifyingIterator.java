package com.jbergin.generic;

import java.util.Iterator;

public interface ModifyingIterator<T> extends Iterator<T> {
	
	public void set(T element);
	
	public void add(T element);

}
