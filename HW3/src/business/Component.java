package business;

public interface Component {
	public void operation(Text text);
	
	public void addOperation(Component operation);
	public void removeOperation(Component operation);
}
