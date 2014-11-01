package character.creation;

public class CreateCharacter {
	
	// Create our new Character
	private Character character = new Character();
	
	// Set up the character's appearance
	private Appearance appearance = new Appearance();
	
	private Attributes attributes = new Attributes();
	
	private CharacterClass characterClass = new CharacterClass();

	public static void main(String[] args) {
		CreateCharacter cc = new CreateCharacter();
		cc.createAppearance();
		cc.attributes();
		cc.characterClass();

	}

	private void createAppearance() {
		String name = appearance.getName();
		character.setName(name);	
	}
	
	public void attributes() {
		int attributePoints = 20;
		System.out.println("You begin with 20 points to spend on attributes");
		System.out.println("You start with a base of 10 of each attribute");
		while (attributePoints > 0) {
			
			int strength = attributes.strength(attributePoints);
			System.out.println("Your strength is at: " + strength + ".");
			attributePoints = (attributePoints - strength) + 10;
			character.setStrength(strength);
			
			int intelligence = attributes.intelligence(attributePoints);
			System.out.println("Your intelligence is at: " + intelligence + ".");
			attributePoints = (attributePoints - intelligence) + 10;
			character.setIntelligence(intelligence);
			
			int agility = attributes.agility(attributePoints);
			System.out.println("Your agility is at: " + agility + ".");
			attributePoints = (attributePoints - agility) + 10;
			character.setAgility(agility);
			
			int wisdom = attributes.wisdom(attributePoints);
			System.out.println("Your wisdom is at: " + wisdom + ".");
			attributePoints = (attributePoints - wisdom) + 10;
			character.setWisdom(wisdom);
			
			int constitution = attributes.constitution(attributePoints);
			System.out.println("Your constitution is at: " + constitution + ".");
			attributePoints = (attributePoints - constitution) + 10;
			character.setConstitution(constitution);
		}
		
	}
	
	public void characterClass() {
		System.out.println("You can choose 1 of the four classes");
		characterClass.description();
		String className = characterClass.chooseClass();
		character.setCharacterClass(className);
	}
	

}
