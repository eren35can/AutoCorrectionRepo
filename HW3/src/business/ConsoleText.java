package business;

public class ConsoleText implements Text {

	//text's value
	private String value;
	
	//file name
	private String fileName;
	
	//for searcher
	private String character;
	
	public ConsoleText(String newValue, String newFileName) {
		setValue(newValue);
		setFileName(newFileName);
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String newFileName) {
		fileName = newFileName;
	}

}
