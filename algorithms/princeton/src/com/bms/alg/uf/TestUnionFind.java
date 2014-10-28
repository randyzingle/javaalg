package com.bms.alg.uf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class TestUnionFind {

	private int cnt;
	private ArrayList<String> pairs;
	@Before
	public void setUp() throws Exception {
		try {
			File txt = new File("data/tempUF.txt");
			System.out.println(txt);
			if (txt != null) {
				// read a file, line by line
				FileReader fr = new FileReader(txt);
				BufferedReader br = new BufferedReader(fr);
				String s = null;
				boolean first = true;
				while ((s = br.readLine()) != null) {
					if (first) {
						cnt = Integer.parseInt(s.trim());
						pairs = new ArrayList<String>(cnt);
						first = false;
						System.out.println("number of nodes: " + s);
					} else {
						pairs.add(s);
//						System.out.println(s);
					}
				}
				br.close();
				System.out.println("number of unions: " + pairs.size());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testUnionQuickFind() {
		UnionFind uf = new QuickFindUF(cnt);
		int n = uf.count();	
		for (int i=0; i<pairs.size(); i++) {
			String[] s = pairs.get(i).trim().split("\\s+");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			uf.union(p, q);
		}
		uf.printNodes();
	}
	
	@Test
	public void testQuickUnionFind() {
		UnionFind uf = new QuickUnionFind(cnt);
		int n = uf.count();	
		for (int i=0; i<pairs.size(); i++) {
			String[] s = pairs.get(i).trim().split("\\s+");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			uf.union(p, q);
		}
		uf.printNodes();
	}
	
	@Test
	public void testWeightedQuickUnionFind() {
		UnionFind uf = new WeightedQuickUnionUF(cnt);
		int n = uf.count();	
		for (int i=0; i<pairs.size(); i++) {
			String[] s = pairs.get(i).trim().split("\\s+");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			uf.union(p, q);
		}
		uf.printNodes();		
	}
	
	
}
