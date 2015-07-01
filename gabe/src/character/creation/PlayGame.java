package character.creation;

public class PlayGame {
	
		private static Character character = new Character();
		private static Appearance appearance = new Appearance();
		private static Attributes attributes = new Attributes();
		private static CharacterClass characterClass = new CharacterClass();
		private static CreateCharacter createCharacter = new CreateCharacter();
		private static FileBrowser fileBrowser = new FileBrowser();
		private static IntroQuests introQuests = new IntroQuests();
		private static Weapons w = new Weapons();
		
	public static void main(String[] args) {
		Character c = createCharacter.characterCreation();
		System.out.println("NAME::::: " + c);
		System.out.println("Your class is: " + c.getCharacterClass() + ".");
		for (int i = 0; i < 30; i++) {
			int damage = w.roleDamage(c.getWeapon());
			System.out.println("You deal " + damage + " damage.");
		}
		//fileBrowser.readFileDescriptions(1);
		//fileBrowser.readFileDescriptions(2);
		//introQuests.moveZone();
		//System.out.println("Your characters name is: " + character.getName());
		//System.out.println("Your characters Strength is: " + character.getStrength());
		//System.out.println("Your characters class is: " + character.getCharacterClass());
		
	}
	


}
