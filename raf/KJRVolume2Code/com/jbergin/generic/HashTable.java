package com.jbergin.generic;

import java.util.Collection;
import java.util.Iterator;

/** This is something like Java's HashSet, though implemented directly rather than
 * through a HashMap. It is to demonstrate a simple "separate chaining" hash mechanism
 * Important Caveat: This is not adaptable in size. As you add, the performance gets worse.
 * For the best performance, make buckets close to your expected capacity. 
 * @author jbergin
 *
 * @param <T> the element type to be held in the set
 */
public class HashTable<T> implements Iterable<T>, Collection<T>{
	
	private DenseList<DenseList<T>> bucketTable = null;
	private int size = 0;
	
	public HashTable(int buckets){
		bucketTable = new DenseList<DenseList<T>>(buckets);
		for(int i = 0; i < buckets; ++i){
			bucketTable.add(null); // expand the size
		}
	}
	
	private int doHash(T element){
		return element.hashCode() % bucketTable.size();
	}

	public Iterator<T> iterator() {
		return new Iterator<T>(){
			
			private Iterator<T> currentIterator = null;
			private int count = 0;

			public boolean hasNext() {
				if(currentIterator == null || !currentIterator.hasNext()){
					while(count < bucketTable.size() && (currentIterator == null
							|| !currentIterator.hasNext())){
						if(bucketTable.get(count) == null){
							count++;
							continue;
						}
						currentIterator = bucketTable.get(count).iterator();
						count++;
					}
				}
				if(count > bucketTable.size()){
					return false; 
				}
				if(currentIterator == null || !currentIterator.hasNext()){
					return false;
				}					
				return true;
			}

			public T next() {
				return currentIterator.next();
			}

			public void remove() {
				throw new UnsupportedOperationException("remove not implemented.");
			}
		};
	}
	
	private int contains(DenseList<T> list, T element){
		int result = -1;
		int count = 0;
		for(T value:list){
			if(value.equals(element)){
				result = count;
				break;
			}
			count++;
		}
		return result;
	}

	public boolean add(T o) {
		int where = doHash(o);
		DenseList<T> list = bucketTable.get(where);
		if (list == null){
			list = new DenseList<T>();
			bucketTable.set(where, list);
		}
//		int which = where;
		where = contains(list, o);
		if(where >= 0){
			return false; // don't change it
		}
		list.add(o);
//		System.out.println("added " + o.toString() + " to " + which);
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
		size = 0;
		bucketTable = new DenseList<DenseList<T>>();	
	}

	public boolean contains(Object o) {
		try{
			T to = (T)o; // might fail
			int where = doHash(to);
			DenseList<T> list = bucketTable.get(where);
			if (list == null){
//				System.out.println("null list");
				return false;
			}
			where = contains(list, to);
//			System.out.println("where " + where);

//			for(T value:list){
//				if(value.equals(to)){
//					return true;
//				}
//			}
			return where >= 0;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
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

	public boolean remove(Object o) {
		try{
			T to = (T)o;
			int where = doHash(to);
			DenseList<T> list = bucketTable.get(where);
			if (list == null){
				return false;
			}
			boolean wasThere = list.remove(to);
			if (wasThere){
				size--;
			}
			return wasThere;
		}
		catch(Exception e){
			System.out.println(e);
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
