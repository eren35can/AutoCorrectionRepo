package business;

public class Line implements Text {

	private final String type = "Line";
	private String value;
	
	public Line(String value) {
		setValue(value);
	}
	
	public Text getText() {
		return this;
	}
	
	public String getType() {
		return type;
	}
	
	public String getValue() {
		return value;
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
		System.out.println("-Line-\n" + this.getValue());
	}

}
