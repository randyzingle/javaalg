package character.creation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterClass {
	
	Scanner input = new Scanner(System.in);
	String className;

	public int description() {
		System.out.println("For a description of each class, enter 1.");
		System.out.println("Any other value will continue character creation to class selection.");
		int description = input.nextInt();
		if (description == 1) {
			System.out.println("The Fighter has higher armor and hitpoints than other classes, "
					+ "although lacks damage relative to other classes.");
			System.out.println("The Rogue has high physical damage, although lacks "
					+ "hitpoints and armor, with the exception of evasive and stealth tacticts.");
			System.out.println("The Mage casts all sorts of magical spells including those of "
					+ "the domains of destruction and conjuration. Armor and hitpoints are low, "
					+ "although protective spells will aid in the Mage's survival");
			System.out.println("The Cleric is a moderately well armored class with the "
					+ "ability to cast numerous protection and healing spells. Althogh, "
					+ "the cleric has low damage relative to other classes.");
		}
		return 0;
		
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
			} catch(InputMismatchException ime) {
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
