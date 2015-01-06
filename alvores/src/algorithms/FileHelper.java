package algorithms;

import java.io.*;
import java.util.*;

public class FileHelper {
	
	public int[] getIntegerArrayFromFile(String fileName) {
		int[] i = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			ArrayList<Integer> list = new ArrayList<Integer>();
			String s = null;
			while ( (s = br.readLine()) != null) {
				int tmp = Integer.parseInt(s);
				list.add(tmp);
			}
			i = new int[list.size()];
			for (int j=0; j<list.size(); j++) {
				i[j] = list.get(j).intValue();
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
 	}

}
