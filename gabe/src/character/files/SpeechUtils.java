package character.files;

import java.util.*;

public class SpeechUtils {
	
	public void sayHello() {
		System.out.println("Hello There!");
	}
	
	public static void realSpeech (ArrayList<String> gameText, int timeMilliSec) {
		for (String s: gameText) {
			System.out.println(s);
			try {
				Thread.sleep(timeMilliSec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void realSpeechScrolling(ArrayList<String> gameText, int timeMilliSec) {
		for (String s: gameText) {
			char[] line = s.toCharArray();
			for (int i = 0; i < line.length; i++) {
				System.out.print(line[i]);
				try {
					Thread.sleep(timeMilliSec);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}

}
