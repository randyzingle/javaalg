package character.creation;

import java.util.Scanner;

public class IntroQuests {
	
	public void moveZone() {
		int choice = moveZoneChoice();
		
		while (choice != 1 && choice != 2 && choice != 3) {
		if (choice == 1) {
			//Go to wolf cave.
			System.out.println("You head out towards the caves of wolves.");
		} else if (choice == 2) {
			//Go to caravan ambushes.
			System.out.println("You head out towards the merchant caravans.");
		} else if (choice == 3) {
			//Go to orc camp.
			System.out.println("You head out towards the camp of orcs.");
		} else {
			System.out.println("That input selection is not valid, please choose from the listed numbers.");
		}
		}
	}

	public int moveZoneChoice () {
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		input.close();
		
		return choice;
	}
	
}
