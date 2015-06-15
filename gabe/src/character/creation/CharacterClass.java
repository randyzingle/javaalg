package character.creation;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class CharacterClass {
	
	Scanner input = new Scanner(System.in);
	String className;

	// Reads a file which includes class descriptions.
	public void description() {
		//File textFile = new File("gabrielfinnerzingle\\work\\projects\\javaalg\\gabe\\src\\characte\\creation\\classes.txt");
		File textFile = new File("intro.txt");
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
		
		
//		System.out.println("There are four class that may be chosen. ");
//		System.out.println("Below is a brief description of the classes.");
//			System.out.println("The Fighter has higher armor and hit points than other classes, "
//					+ "although lacks damage relative to other classes.");
//			System.out.println("The Rogue has high physical damage, although lacks "
//					+ "hit points and armor, with the exception of evasive and stealth tacticts.");
//			System.out.println("The Mage casts an assortment of arcane spells. Armor and hit points are low, "
//					+ "although protective spells will aid in the Mage's survival.");
//			System.out.println("The Cleric is a moderately well armored class with the "
//					+ "ability to cast numerous protection and healing spells. Although, "
//					+ "the Cleric has low damage relative to other classes.");
		
	}
	
	private void printClassChoices() {
		System.out.println("Enter the number for the desired class: ");
		System.out.println("1 = Fighter");
		System.out.println("2 = Rogue");
		System.out.println("3 = Mage");
		System.out.println("4 = Cleric");
	}

	public String chooseClass() {
		printClassChoices();
		
		int choice = 0;	
		boolean classChosen = false;
		while (!classChosen) {
			try {
				choice = input.nextInt();
				if (choice > 0 && choice < 5) {
					classChosen = true;
					break;
				}
			} catch (InputMismatchException ime) {
				ime.printStackTrace();
			}
			System.out.println("Sorry that wasn't one of the allowed choices, try one of the below:");
			this.printClassChoices();
		}
		
		
		if (choice == 1) {
			className = "Fighter";
		} else if (choice == 2 ) {
			className = "Rogue";
		} else if (choice == 3) {
			className = "Mage";
		} else if (choice == 4) {
			className = "Cleric";
		} else {
			
		}
		return className;
	}
}
