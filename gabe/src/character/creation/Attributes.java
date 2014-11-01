package character.creation;

import java.util.Scanner;

public class Attributes {
	Scanner input = new Scanner(System.in);
	
	public int strength (int attributePoints) {
		System.out.println("You have : " + attributePoints + " attribute points.");
		System.out.println("How many points do you want to spend on enhancing strength?");
		int strength = input.nextInt();
		while (strength > attributePoints) {
			System.out.println("You don't have that many points to spend, please enter a lower value.");
			strength = input.nextInt();
		}
		strength += 10;
		return strength;
		
	}
	
	public int intelligence (int attributePoints) {
		System.out.println("You have : " + attributePoints + " attribute points.");
		System.out.println("How many points do you want to spend on enhancing intelligence?");
		int intelligence = input.nextInt();
		while (intelligence > attributePoints) {
			System.out.println("You don't have that many points to spend, please enter a lower value.");
			intelligence = input.nextInt();
		}
		intelligence += 10;
		return intelligence;
		
	}
	
	public int agility (int attributePoints) {
		System.out.println("You have : " + attributePoints + " attribute points.");
		System.out.println("How many points do you want to spend on enhancing agility?");
		int agility = input.nextInt();
		while (agility > attributePoints) {
			System.out.println("You don't have that many points to spend, please enter a lower value.");
			agility = input.nextInt();
		}
		agility += 10;
		return agility;
		
	}
	
	public int wisdom (int attributePoints) {
		System.out.println("You have : " + attributePoints + " attribute points.");
		System.out.println("How many points do you want to spend on enhancing wisdom?");
		int wisdom = input.nextInt();
		while (wisdom > attributePoints) {
			System.out.println("You don't have that many points to spend, please enter a lower value.");
			wisdom = input.nextInt();
		}
		wisdom += 10;
		return wisdom;
		
	}
	
	public int constitution (int attributePoints) {
		System.out.println("You have : " + attributePoints + " attribute points.");
		System.out.println("How many points do you want to spend on enhancing constitution?");
		int constitution = input.nextInt();
		while (constitution > attributePoints) {
			System.out.println("You don't have that many points to spend, please enter a lower value.");
			constitution = input.nextInt();
		}
		constitution += 10;
		return constitution;
		
	}

}
