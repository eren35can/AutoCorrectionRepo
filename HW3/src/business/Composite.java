package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements Component {
	
	//list of operations
	private List<Component> operationList;
	
	public Composite() {
		operationList = new ArrayList<>();
	}
	
	//it applies all operations inside the operation list to the text
	public void operation(Text text) {
		Iterator<Component> operationIterator = operationList.iterator();
		while (operationIterator.hasNext()) {
			Component op = operationIterator.next();
			op.operation(text);
		}
	}
	
	//adding operation to the operation list
	public void addOperation(Component operation) {
		operationList.add(operation);
	}
	
	//removing operation from the operation list
	public void removeOperation(Component operation) {
		operationList.remove(operation);
	}

}
