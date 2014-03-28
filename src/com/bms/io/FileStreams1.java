package com.bms.io;

import java.io.*;
import java.util.*;

public class FileStreams1 {
	
	private String BASE_PATH = "/home/rzingle/work/projects/java/javaalg/src/assets/";
	
	public static void main(String[] args) {
		new FileStreams1().run();
	}
	
	private void copyImage() throws Exception {
		FileInputStream fis = new FileInputStream(BASE_PATH + "020.JPG");
		FileOutputStream fos = new FileOutputStream(BASE_PATH+"mel.jpg");
		int c;
		
		while ( (c = fis.read()) != -1) {
			fos.write(c);
		}
		
		fis.close();
		fos.close();
	}
	
	private void printText() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(BASE_PATH+"t.txt"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String s = null;
		int nmb = 0;
		while ((s = br.readLine()) != null) {
			s = s.replaceAll("--", " ");
			String[] sa = s.split(" ");
			for (String sx : sa) {
				sx = sx.replaceAll("\\W", "");
//				System.out.println(sx);
				if (map.containsKey(sx)) {
					int cnt = map.get(sx);
					map.put(sx, cnt+1);
				} else {
					map.put(sx, 1);
					nmb++;
				}
			}	
			System.out.println(s);
		}
		br.close();
		
		
		System.out.printf("Found %d distinct words\n", nmb);
		System.out.printf("Map has %d keys\n", map.keySet().size());
		TreeSet<WordBucket> ss = new TreeSet<WordBucket>();
		for (String key : map.keySet()) {
			System.out.printf("%s : %d\n", key, map.get(key));
			ss.add(new WordBucket(key, map.get(key)));
		}
		
		int nwords = 0;
		for (WordBucket wb : ss) {
			nwords = nwords + wb.value;
//			System.out.println(nwords + ") " + wb.toString());
		}
		
	}
	
	private void run() {
		try {
			copyImage();
			printText();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private class WordBucket implements Comparable<WordBucket> {
		String key;
		Integer value;
		
		public WordBucket(String key, Integer value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(WordBucket wb) {
			int oval = wb.value;
			if (this.value < oval) {
				return -1;
			} else if (this.value > oval) {
				return 1;
			} else {
				return 0;
			}
		}
		
		@Override 
		public String toString() {
			return this.key + ": " + this.value;
		}

	}

}
