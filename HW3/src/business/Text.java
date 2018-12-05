package business;

public interface Text {
	
	public void add(Text text);
	public void remove(Text text);
	
	public String getType();
	public String getValue();
	
	public void printText();

}
