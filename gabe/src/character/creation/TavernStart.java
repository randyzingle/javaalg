package character.creation;

import java.util.Scanner;
import java.io.*;

public class TavernStart {

	private Scanner input = new Scanner(System.in);

	public void introduction() {

		File textFile = new File("innKeeper.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;

		try {
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
				System.out.println(lineOfText);
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
		
	}
	
	public void moveQuest() {
		File textFile = new File("moveQuest.txt");
		FileReader in;
		BufferedReader readFile;
		String lineOfText;

		try {
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			while ((lineOfText = readFile.readLine()) != null) {
				System.out.println(lineOfText);
			}
			readFile.close();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IOException: " + e.getMessage());
		}
	}
}
