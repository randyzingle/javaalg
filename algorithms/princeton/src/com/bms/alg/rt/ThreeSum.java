package com.bms.alg.rt;
import java.io.*;
import java.util.*;
import com.bms.utils.*;

public class ThreeSum {
	public static boolean debug = true;
	
	public static void main(String[] args) {
		try {
			run(args[0]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static void run(String fileName) throws Exception {
		if(debug) fileName = "data/2Kints.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<Integer> al = new ArrayList<Integer>();
		String s = null;
		while ( (s = br.readLine()) != null) {
			int n = Integer.parseInt(s.trim());
			al.add(n);
		}
		br.close();
		
		if(debug) System.out.printf("Read %d integers from %s%n", al.size(), fileName);
		int[] a = new int[al.size()];
		for (int i=0; i<al.size(); i++){
			a[i] = al.get(i);
		}
		
		countTriples(a);
	}

	public static void countTriples(int[] a) {
		Stopwatch sw = new Stopwatch();
		int n = a.length;
		int cnt = 0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					if ((a[i] + a[j] + a[k]) == 0) cnt++;
				}
			}
		}
		System.out.println("Elapsed Time: " + sw.getElapsedTimeInSecs() + " secs" + " Triples: " + cnt);
		
	}

}
