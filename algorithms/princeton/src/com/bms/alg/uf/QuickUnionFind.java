package com.bms.alg.uf;

import java.util.Arrays;

public class QuickUnionFind implements UnionFind {
	
	private int[] id;
	private int cnt;
	
	public QuickUnionFind(int n) {
		cnt = n;
		id = new int[n];
		for (int i=0; i<n; i++) {
			id[i] = i;
		}
	}

	@Override
	public int count() {
		return cnt;
	}

	@Override
	public void union(int p, int q) {
		// find the root of p
		int i = find(p); // root of p's component
		int j = find(q); // root of q's component
		if (i == j) return; // already in the same component
		id[i] = j; // else attach the root of p's component to the root of q's
		cnt--;
	}

	@Override
	// we are finding the root of the component that p is in
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}

	@Override
	// do p and q have the same root
	public boolean connected(int p, int q) {
		int i = find(p); // root of p
		int j = find(q); // root of q
		return (i == j);
	}

	@Override
	public void printNodes() {
		String s = Arrays.toString(id);
		System.out.println("QuickUnionFind");
		System.out.println(s.replace(',',' '));
		System.out.println(s);
		System.out.println("Number of components: " + cnt);
	}
	
	

}
