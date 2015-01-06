package algorithms;

import java.io.*;
import java.util.ArrayList;

public class SimpleFileRead {

	public static void main(String[] args) {
		try {
			runit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static void runit() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String fileName = "data/tinyW.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String s = null;
		while ( (s = br.readLine()) != null) {
//			System.out.println(s);
			int i = Integer.parseInt(s);
			list.add(i);
		}
		br.close();
		System.out.println(list);
		int listSize = list.size();
		int[] whiteList = new int[listSize];
		for (int i=0; i<listSize; i++) {
			whiteList[i] = list.get(i);
		}
		System.out.println(whiteList[0] + whiteList[1]);
	}

}
