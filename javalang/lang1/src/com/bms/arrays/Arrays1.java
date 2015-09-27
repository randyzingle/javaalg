package com.bms.arrays;

import java.util.Arrays;

public class Arrays1 {

	public static void main(String[] args) {
		String[] s1 = new String[5];
		s1[0] = "bob";
		
		String[] s2 = {"this", "skips", "new statement"};
		
		System.out.println(s1[0]);
		System.out.println(s2[0]);
		
		int[] x = new int[100];
		for (int i=0; i<x.length; i++) {
			x[i] = (int) Math.round(Math.random() * 100);
		}
		Arrays.sort(x);
		int max = x[99];
		int min = x[0];
		System.out.println("max: " + max + ", min:" + min);

	}

}
