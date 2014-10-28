package com.bms.alg.uf;

import java.util.Arrays;
import java.io.*;

public class WeightedQuickUnionUF implements UnionFind {
	
	private int[] id; // array of objects identified by index - value gives union root
	private int cnt; // number of objects
	private int[] sz; // size of tree for the component the node is in
	
	public static void main(String[] args) {
		UnionFind uf = null; 
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data/mediumUF.txt")));
			String s = null;
			boolean first = true;
			while ( (s = br.readLine()) != null) {
				if (first) {
					int n = Integer.parseInt(s.trim());
					uf = new WeightedQuickUnionUF(n);
					first = false;
				} else {
					String[] sa = s.trim().split("\\s+");
					int p = Integer.parseInt(sa[0]);
					int q = Integer.parseInt(sa[1]);
					uf.union(p, q);
				}
			}
			br.close();
			uf.printNodes();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public WeightedQuickUnionUF(int n) {
		cnt = n; // each node starts in it's own component
		id = new int[n];
		sz = new int[n];
		for (int i=0; i<n; i++) {
			id[i] = i; // component name = node name
			sz[i] = 1; // all nodes start in their own component -> size = 1
		}
	}

	@Override
	public int count() {
		return cnt;
	}

	@Override
	public void union(int p, int q) {
		int i = find(p); // root of p's tree
		int j = find(q); // root of q's tree
		if (i == j) return; // they are already in the same component
		cnt--;
		if (sz[i] < sz[j]) {
			id[i] = j; // move the smaller tree to the larger tree
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}

	}

	@Override
	public int find(int p) {
		// walk up to the root of the component
		while (p != id[p]) p = id[p];
		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		int i = find(p);
		int j = find(q);
		return (i==j);
	}

	@Override
	public void printNodes() {
		String s = Arrays.toString(id);
		System.out.println("Weighted Quick Union");
		System.out.println(s.replace(',',' '));
		System.out.println(s);
		System.out.println("Number of components: " + cnt);
		for (int i=0; i<id.length; i++) {
			if (id[i] == i) {
				System.out.printf("root: %d, size of tree: %d%n", i, sz[i]);
			}
		}
	}

}
