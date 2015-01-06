package algorithms;

import java.util.Arrays;

public class Exercise1_2_9 {

	public static void main(String[] args) {
		String file1 = "data/tinyW.txt";
		String file2 = "data/tinyT.txt";
		FileHelper fh = new FileHelper();
		int[] whitelist = fh.getIntegerArrayFromFile(file1);
		int[] otherlist = fh.getIntegerArrayFromFile(file2);
		
		System.out.println(Arrays.toString(whitelist));
		Arrays.sort(whitelist);
		System.out.println(Arrays.toString(whitelist));
		

	}
	
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

}
