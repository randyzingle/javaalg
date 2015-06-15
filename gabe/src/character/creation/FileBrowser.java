package character.creation;

import java.io.*;
import java.util.*;

import character.files.*;

public class FileBrowser {

	public static void main(String[] args) {
//		System.out.println("hello from filebrowser");
		String dir = System.getProperty("user.dir");
//		System.out.println(dir);
		String path = "files/";
		ArrayList<String> speech = FileUtils.getFileText(path + "innKeeper.txt" );


	}

}
