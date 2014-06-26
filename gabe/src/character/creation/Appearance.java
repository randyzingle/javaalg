package character.creation;

import java.util.Scanner;

public class Appearance {
	
	private Scanner input = new Scanner(System.in);
	
	public String getName() {
		System.out.println("What will be your characters name? ");
		String name = input.next();
		return name;
	}
	
	private String whatsUp() {
		return "not much";
	}

}
