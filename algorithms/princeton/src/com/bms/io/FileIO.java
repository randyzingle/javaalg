package com.bms.io;
import java.io.*;
import java.util.ArrayList;

public class FileIO {

	public static void main(String[] args) {
		try {
			// If I create a new file with no prefix, what would it's absolute path be?
			// here it will be the princeton directory just above the src directory
			System.out.println(new java.io.File("").getAbsolutePath());
			
			// get a handle to the working directory
			File f = new File(".");
			// it should have the same canonical path as the new file created above
			System.out.println(f.getCanonicalPath());
			// list all files and directories in this directory
			File[] fs = f.listFiles();
			System.out.println(fs.length);
			for (File file : fs) {
				System.out.println(file.getCanonicalPath());
			}
			// open a file in the data directory
			File txt = new File("data/runtime1.txt");
			System.out.println(txt);
			if (txt != null) {
				// read a file, line by line
				FileReader fr = new FileReader(txt);
				BufferedReader br = new BufferedReader(fr);
				String s = null;
				ArrayList<Double> al = new ArrayList<Double>();
				while ((s = br.readLine()) != null) {
//					System.out.println(s);
					String[] ts = s.trim().split("\\s+");
//					System.out.println(ts[0] + "," + ts[1]);
					if (ts != null && ts.length > 1) {
						al.add(Double.parseDouble(ts[1]));
					}
				}
				System.out.println(al);
				for (int i=0; i<al.size()-1; i++) {
					double d1 = al.get(i);
					double d2 = al.get(i+1);
					if (d1 != 0.0) System.out.println(i + ": " + d2 / d1);
				}
				br.close();
				fr.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
