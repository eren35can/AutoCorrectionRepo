package business;

public class FileText implements Text {
	
	private String value;
	private String character;
	
	public FileText(String newValue) {
		value = newValue;
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
