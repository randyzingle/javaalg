package com.bms.alg.uf;

import java.util.Arrays;

public class QuickFindUF implements UnionFind {
	
	private int[] id; // array of objects identified by index - value gives union root
	private int cnt; // number of objects
	
	public QuickFindUF(int n) {
		cnt = n;
		id = new int[cnt];
		for (int i=0; i<cnt; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return cnt;
	}
	
	public void union(int p, int q) {
		// add a connection between p and q
		int i = find(p);
		int j = find(q);
		if (i == j) return; // bail - already same component
		// go through entire array and change any node that is in p's component to q's component
		for (int index=0; index < id.length; index++) {
			if(find(index) == i) id[index] = j;
		}
		cnt--;
	}
	
	public int find(int p) {
		// return the root component id for object p
		return id[p];
	}
	
	public boolean connected(int p, int q) {
		// return true if p and q are in the same component -> have the same root
		return (find(p) == find(q));
	}
	
	public void printNodes() {
		String s = Arrays.toString(id);
		System.out.println("QuickFind");
		System.out.println(s.replace(',',' '));
		System.out.println(s);
		System.out.println("Number of components: " + cnt);
	}
	

}
