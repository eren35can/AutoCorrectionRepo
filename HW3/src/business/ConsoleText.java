package business;

public class ConsoleText implements Text {

	//text's value
	private String value;
	
	//for searcher
	private String character;
	
	public ConsoleText(String newValue) {
		setValue(newValue);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String newValue) {
		value = newValue;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String newCharacter) {
		character = newCharacter;
	}

}
