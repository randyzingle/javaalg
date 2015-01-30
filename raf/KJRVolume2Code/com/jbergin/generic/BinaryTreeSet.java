package com.jbergin.generic;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/** A class similar to, but simpler than a java TreeSet. It is not balanced, however.
 * @author jbergin
 *
 * @param <T> the element type of the data
 */
public class BinaryTreeSet<T> implements Iterable<T>, Collection<T>{
	
	private Comparator<T> comparator;
	private int size = 0;
	private TreeNode<T> root = null;


	public BinaryTreeSet(){ // requires T implement Comparable<T>
		this.comparator = new Comparator<T>(){

			public int compare(T o1, T o2) {
				
				return ((Comparable<T>)o1).compareTo(o2);
			}
			
		};
	}
	
	public BinaryTreeSet(Comparator<T> comparator){
		this.comparator = comparator;
	}
	
	private void fill(TreeNode<T> node, DenseList<T> list){
		if(node.getLeftChild() != null){
			fill(node.getLeftChild(), list);
		}
		list.add(node.getValue());
		if(node.getRightChild() != null){
			fill(node.getRightChild(), list);
		}
	}
	
	public Iterator<T> iterator() {
		DenseList<T> copies = new DenseList<T>(size);
		fill(root, copies);
		return copies.iterator();
	}

	public boolean add(T o) {
		if(root == null){
			root = new TreeNode<T>(o, null, null);
			size++;
			return true;
		}
		TreeNode<T> node = root;
		TreeNode<T> parent = node;
		while (node != null && ! o.equals(node.getValue())){
			parent = node;
			if(comparator.compare(o, node.getValue()) < 0){
				node = node.getLeftChild();
			}
			else{
				node = node.getRightChild();
			}
		}
		if(node != null){
			return false;
		}
		node = new TreeNode<T>(o, null, null);
		if(comparator.compare(o, parent.getValue()) < 0){
			parent.setLeftChild(node);
		}
		else{
			parent.setRightChild(node);
		}
		size++;
		return true;
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

	public void clear() {
		root = null;
		size = 0;
	}

	public boolean contains(Object o) {
		if (root == null){
			return false;
		}
		try{
			TreeNode<T> node = root;
			while(node != null){
				T value = node.getValue();
				if(value.equals(o)){
					return true;
				}
				if(comparator.compare((T)o, value) < 0){
					node = node.getLeftChild();
				}
				else{
					node = node.getRightChild();
				}
			}
		}
		catch(Exception e){
			return false;
		}
		return false;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	private TreeNode<T> promote(TreeNode<T> node){
		if(node.getLeftChild() != null){
			node.setValue(node.getLeftChild().getValue());
			node.setLeftChild(promote(node.getLeftChild()));
			return node;
		}
		else if(node.getRightChild() != null){
			node.setValue(node.getRightChild().getValue());
			node.setRightChild(promote(node.getRightChild()));
			return node;
		}
		return null;
	}

	public boolean remove(Object o) {
		if(root == null){
			return false;
		}
		if(root.getValue().equals(o)){
			if(root.getLeftChild() != null){
				root.setValue(root.getLeftChild().getValue());
				root.setLeftChild(promote(root.getLeftChild()));
			}
			else if(root.getRightChild() != null){
				root.setValue(root.getRightChild().getValue());
				root.setRightChild(promote(root.getRightChild()));
			}
			else root = null;
			size--;
			return true;
		}
		TreeNode<T> node = root;
		TreeNode<T> parent = node;
		boolean wasLeft = false;
		try{
			while(node != null && !node.getValue().equals(o)){
				int compare = comparator.compare((T)o, node.getValue());
				if(compare < 0){
					parent = node;
					node = node.getLeftChild();
					wasLeft = true;
				}
				else if(compare > 0){
					parent = node;
					node = node.getRightChild();
					wasLeft = false;
				}
			}
			if(node == null){
				return false; // not found
			}
			if(wasLeft){
//				parent.setValue(node.getValue());
				parent.setLeftChild(promote(node));
			}
			else{
//				parent.setValue(node.getValue());
				parent.setRightChild(promote(node));
			}
			size--;
			return true;
			
		}
		catch(Exception e){
			return false;
		}
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

	public int size() {
		return size;
	}

	public boolean containsAll(Collection<?> c) {
		for(Object value:c){
			if(!contains(value)){
				return false;
			}
		}
		return true;
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
