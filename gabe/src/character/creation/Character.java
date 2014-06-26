package character.creation;

public class Character {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	private String name;
	private String characterClass;
	
	@Override
	public String toString() {
		return name + " the " + characterClass;
	}

}
