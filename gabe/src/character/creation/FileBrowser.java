package character.creation;

import java.io.*;
import java.util.*;

import character.files.*;

public class FileBrowser {
	

	public static void readFileDescriptions(int choice) {
//		System.out.println("hello from filebrowser");
		//String dir = System.getProperty("user.dir");
		//System.out.println(dir);
		String path = "files/";
		HashMap<String, ArrayList<String>> speechMap = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> speech;
		//ArrayList<String> speech = FileUtils.getFileText(path + "innKeeper.txt" );
		//speechMap.put("innKeeper", speech);
//		SpeechUtils.realSpeech(speech, 0);
		
		//speech = FileUtils.getFileText(path+"innKeeper.txt");
		//speechMap.put("bob", speech);
//		SpeechUtils.realSpeech(speech, 0);
		
	//	speech = speechMap.get("innKeeper");
		//SpeechUtils.realSpeech(speech, 1000);
		//SpeechUtils.realSpeechScrolling(speech, 50);
		
		if (choice == 0) {
			speech = FileUtils.getFileText(path+ "classes.txt");
			speechMap.put("classes", speech);
			SpeechUtils.realSpeechScrolling(speech, 2);
		} else if (choice == 1) {
			speech = FileUtils.getFileText(path+ "innKeeper.txt");
			speechMap.put("innKeeper", speech);
			SpeechUtils.realSpeechScrolling(speech, 2);
		} else if (choice == 2) {
			speech = FileUtils.getFileText(path + "moveQuest.txt");
			speechMap.put("moveQuest", speech);
			SpeechUtils.realSpeechScrolling(speech, 2);
		}

	}
	

}
