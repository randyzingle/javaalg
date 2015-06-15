package character.files;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
	
	public static ArrayList<String> getFileText(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String s = "";
			while ( (s = br.readLine()) != null) {
				list.add(s);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
