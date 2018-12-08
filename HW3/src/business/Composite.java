package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements Component {
	
	private List<Component> operationList;
	
	public Composite() {
		operationList = new ArrayList<>();
	}
	
	public void operation(Text text) {
		Iterator<Component> operationIterator = operationList.iterator();
		while (operationIterator.hasNext()) {
			Component op = operationIterator.next();
			op.operation(text);
		}
	}
	
	public void addOperation(Component operation) {
		operationList.add(operation);
	}
	
	public void removeOperation(Component operation) {
		operationList.remove(operation);
	}

}
