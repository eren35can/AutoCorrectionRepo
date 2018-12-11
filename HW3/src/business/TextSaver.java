package business;

import dataaccess.FileOperations;

public class TextSaver implements Component {

	private FileOperations fileOperations;
	
	public TextSaver() {
		fileOperations = new FileOperations();
	}
	
	//writes text to the file via File Operations class
	public void operation(Text text) {
		fileOperations.writeToFile(text);
	}

}
