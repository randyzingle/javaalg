package fmgv2;

import java.util.HashMap;
import java.util.Map;

public class DefaultHashMap<K, V> extends HashMap<K, V> {
	
	public DefaultHashMap(){
		super();
	}
	
	public DefaultHashMap(int initialCapacity){
		super(initialCapacity);
	}
	
	public DefaultHashMap(int initialCapacity, int loadFactor){
		super(initialCapacity, loadFactor);
	}
	
	public DefaultHashMap(Map<? extends K,? extends V> m){
		super(m);
	}
	
	public V get(K key, V defaultValue){
		V value = get(key);
		if (value == null){
			return defaultValue;
		}
		return value;
	}
}
