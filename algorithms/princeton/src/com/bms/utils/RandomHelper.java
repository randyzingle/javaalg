package com.bms.utils;

import java.util.Arrays;

public class RandomHelper {
	
	public static boolean debug = false;

	public static void main(String[] args) {
//		testGetRandomBelow(100);
//		testGetRandomBetween(-50, 50);
		testGetArrayRandomBetween(-100,100,1000);
	}
	
	private static void testGetArrayRandomBetween(int low, int high, int number) {
		int[] a = getArrayRandomBetween(low, high, number);
		Arrays.sort(a);
		if(debug) System.out.println(Arrays.toString(a));
		System.out.println(a[number/2]);
		
	}

	private static void testGetRandomBetween(int low, int high) {
		int n = 9;
		int max = low;
		int min = high;
		double sum = 0;
		for (int i=0; i<n; i++) {
			int s = getRandomBetween(low, high);
			sum += s;
			if (s < min) min = s;
			if (s > max) max = s;
			if (debug) System.out.println(s);
		}
		int ave = (int)(sum/n);
		System.out.printf("Number: %d, average: %d, min: %d, max: %d%n",n,ave,min,max );
		
	}

	public static void testGetRandomBelow(int ntop) {
		int num = 10;
		int sum = 0;
		int hi = 100;
		int max = 0;
		int min = ntop;
		for (int i=0; i<num; i++) {
			int n = getRandomBelow(hi);
			System.out.println(n);
			if (n < min) min = n;
			if (n > max) max = n;
			sum += n;
		}
		System.out.printf("max: %d, min: %d%n", max, min);
		System.out.println(sum / num);
	}
	
	public static int getRandomBelow(int n) {
		double d = Math.random();
		return (int) (d * n);
	}
	
	public static int getRandomBetween(int low, int high) {
		double d = low + Math.random() * Math.abs(high - low);
		return (int)d;
	}
	
	public static int[] getArrayRandomBetween(int low, int high, int number) {
		int[] a = new int[number];
		for (int i=0; i<number; i++) {
			a[i] = getRandomBetween(low,high);
		}
		return a;
	}
}
