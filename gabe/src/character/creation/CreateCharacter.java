package character.creation;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class CreateCharacter {
	
	// Set up the character's appearance
	private Appearance appearance = new Appearance();
	
	// Distribute the character's attribute points
	private Attributes attributes = new Attributes();
	
	// Choose class of the character
	private CharacterClass characterClass = new CharacterClass();
	
	public Character characterCreation() {
		Character c = new Character();
		createAppearance(c);
		attributes(c);
		characterClass(c);
		weapon(c);
		System.out.println("NAME:::: " + c.getName());
		//System.out.println("Your class is: " + character.getCharacterClass() + ".");
		return c;
	}

	private void createAppearance(Character character) {
		String name = appearance.getName();
		character.setName(name);	
		//System.out.println("NAME::: " + character.getName());
	}
	
	public void attributes(Character character) {
		int attributePoints = 20;
		System.out.println("You begin with 20 points to spend on attributes");
		System.out.println("You start with a base of 10 of each attribute");
		while (attributePoints > 0) {
			
			int strength = attributes.strength(attributePoints);
			System.out.println("Your strength is at: " + strength + ".");
			attributePoints = (attributePoints - strength) + 10;
			character.setStrength(strength);
			
			if (attributePoints <= 0) {
				break;
			}
			
			int intelligence = attributes.intelligence(attributePoints);
			System.out.println("Your intelligence is at: " + intelligence + ".");
			attributePoints = (attributePoints - intelligence) + 10;
			character.setIntelligence(intelligence);
			
			if (attributePoints <= 0) {
				break;
			}
			
			int agility = attributes.agility(attributePoints);
			System.out.println("Your agility is at: " + agility + ".");
			attributePoints = (attributePoints - agility) + 10;
			character.setAgility(agility);
			
			if (attributePoints <= 0) {
				break;
			}
			
			int wisdom = attributes.wisdom(attributePoints);
			System.out.println("Your wisdom is at: " + wisdom + ".");
			attributePoints = (attributePoints - wisdom) + 10;
			character.setWisdom(wisdom);
			
			if (attributePoints <= 0) {
				break;
			}
			
			int constitution = attributes.constitution(attributePoints);
			System.out.println("Your constitution is at: " + constitution + ".");
			attributePoints = (attributePoints - constitution) + 10;
			character.setConstitution(constitution);
			
		}
		
	}
	
	public void characterClass(Character character) {
		System.out.println("You can choose 1 of the four classes");
		characterClass.description();
		String className = characterClass.chooseClass();
		character.setCharacterClass(className);
	}
	
	public void weapon(Character character) {
		int weapon;
		String charClass = character.getCharacterClass();
		if (charClass == "Guardian") {
			weapon = 1;
		} else if (charClass == "Weaponmaster") {
			weapon = 2;
		} else if (charClass == "Cleric") {
			weapon = 3;
		} else if (charClass == "Rogue") {
			weapon = 4;
		} else if (charClass == "Mage") {
			weapon = 5;	
		} 
		//character.setWeapon(weapon);
	}
	

}
