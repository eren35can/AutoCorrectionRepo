package business;

public class Text {

	//text's value
	private String value;
	
	//file name
	private String fileName;
	
	//for searcher
	private String searchCharacters;
	
	public Text(String newValue, String newFileName) {
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
		return searchCharacters;
	}

	public void setCharacter(String newCharacter) {
		searchCharacters = newCharacter;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String newFileName) {
		fileName = newFileName;
	}

}
