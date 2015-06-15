package character.creation;

public class PlayGame {
	
		private static Character character = new Character();
		private static Appearance appearance = new Appearance();
		private static Attributes attributes = new Attributes();
		private static CharacterClass characterClass = new CharacterClass();
		private static CreateCharacter createCharacter = new CreateCharacter();
		private static TavernStart tavernStart = new TavernStart();
	
	//static CreateCharacter cc = new CreateCharacter();
	//static Character c = new Character();
		
	public static void main(String[] args) {
		createCharacter.characterCreation();
		System.out.println("Your characters name is: " + character.getName());
		System.out.println("Your characters Strength is: " + character.getStrength());
		System.out.println("Your characters class is: " + character.getCharacterClass());
		
	}

}
