package character.creation;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class CharacterClass {
	
	Scanner input = new Scanner(System.in);
	String className;

	// Reads a file which includes class descriptions.
	public void description() {
		FileBrowser.readFileDescriptions(0);	
		
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
			while (choice != 5 && choice != 6) {
			System.out.println("Do you wish to bear a 5: shield and a longsword or a 6: greatsword?");
			choice = input.nextInt();
			if (choice == 5) {
				className = "Guardian";
			} else if (choice == 6) {
				className = "Weaponmaster";
			}
			}
			className = "Fighter";
		} else if (choice == 2 ) {
			className = "Rogue";
		} else if (choice == 3) {
			className = "Mage";
		} else if (choice == 4) {
			className = "Cleric";
		} 
		return className;
	}
}
