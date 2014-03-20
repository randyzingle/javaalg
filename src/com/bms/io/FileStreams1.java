package com.bms.io;

import java.io.*;

public class FileStreams1 {
	
	private String BASE_PATH = "/home/rzingle/work/projects/java/javaalg/src/assets/";
	
	public static void main(String[] args) {
		new FileStreams1().run();
	}
	
	private void printBytes() throws Exception {
		FileInputStream fis = new FileInputStream(BASE_PATH + "xanadu.txt");
		int c;
		
		while ( (c = fis.read()) != -1) {
			System.out.println(c);
		}
	}
	
	private void run() {
		try {
			printBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
