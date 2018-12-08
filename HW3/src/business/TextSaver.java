package business;

import dataaccess.FileOperations;

public class TextSaver implements Component {

	private FileOperations fileOperations;
	
	public TextSaver() {
		fileOperations = new FileOperations();
	}
	
	public void operation(Text text) {
		fileOperations.writeToFile(text.getValue());
	}

	public void addOperation(Component operation) {
		
	}

	public void removeOperation(Component operation) {
		
	}

}
