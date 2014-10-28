package com.bms.alg.uf;

public interface UnionFind {
	
	int count();
	void union(int p, int q);
	int find(int p);
	boolean connected(int p, int q);
	void printNodes();

}
