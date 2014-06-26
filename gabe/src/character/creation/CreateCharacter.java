package character.creation;

public class CreateCharacter {
	
	// Create our new Character
	private Character character = new Character();
	
	// Set up the character's appearance
	private Appearance appearance = new Appearance();

	public static void main(String[] args) {
		CreateCharacter cc = new CreateCharacter();
		cc.createAppearance();
		cc.setClass();
		System.out.println(cc.character);
		

	}

	private void createAppearance() {
		String name = appearance.getName();
		character.setName(name);	
	}
	
	private void setClass() {
		character.setCharacterClass("Viking");
	}
	

}
