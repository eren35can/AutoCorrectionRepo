package business;

public class Word implements Text {

	private final String type = "Word";
	private String value;
	
	public Word(String value) {
		setValue(value);
	}
	
	public Text getText() {
		return this;
	}
	
	public String getType() {
		return type;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public void add(Text text) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Text text) {
		// TODO Auto-generated method stub
		
	}

	public void printText() {
		System.out.println("-Word-\n" + this.getValue());
	}

}
