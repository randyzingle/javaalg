package character.creation;

import java.io.*;
import java.util.*;

public class FileBrowser {

	public static void main(String[] args) {
//		System.out.println("hello from filebrowser");
		String dir = System.getProperty("user.dir");
//		System.out.println(dir);
		String path = "files/";
		ArrayList<String> speech = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "innKeeper.txt"));
			String s = "";
			while ( (s=br.readLine()) != null) {
				speech.add(s);
			}
			//for (int i=0; i<speech.size(); i++) {String ss = speech.get(i);}
			for (String ss : speech) {
				System.out.println(ss);
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
