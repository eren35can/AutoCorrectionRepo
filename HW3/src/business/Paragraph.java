package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paragraph implements Text {
	
	private final String type = "Paragraph";
	private String value;
	private List<Text> textList;
	
	public Paragraph(String value) {
		setValue(value);
		this.textList = new ArrayList<>();
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

	public List<Text> getTextList() {
		return textList;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void add(Text text) {
		textList.add(text);
	}

	public void remove(Text text) {
		textList.remove(text);
	}

	public void printText() {
		System.out.println("-Paragraph-\n" + this.getValue());
		
		Iterator<Text> textIterator = this.textList.iterator();
		while(textIterator.hasNext()) {
			Text text = (Text) textIterator.next();
			text.printText();
		}
	}

}
