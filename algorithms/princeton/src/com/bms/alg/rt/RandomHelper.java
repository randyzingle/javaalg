package com.bms.alg.rt;

public class RandomHelper {

	public static void main(String[] args) {
		testGetRandomBelow(100);
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
	
	public static int getRandomBetween(int n, int m) {
		return 1;
	}

}
