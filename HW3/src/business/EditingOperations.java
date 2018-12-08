package business;

import dataaccess.FileOperations;
import presentation.Menu;

public class EditingOperations {

	private Component textSaver;
	private Component autoCorrector;
	private Component counter;
	private Component searcher;
	private Component composite;
	
	private Menu menu;
	private FileOperations fileOperations;
	
	private Text consoleText;
	private Text fileText;
	
	public EditingOperations() {
		textSaver = new TextSaver();
		autoCorrector = new AutoCorrector();
		counter = new Counter();
		searcher = new Searcher();
		composite = new Composite();
		
		menu = new Menu();
		fileOperations = new FileOperations();
		
		composite.addOperation(autoCorrector);
		composite.addOperation(counter);
		composite.addOperation(textSaver);
	}
	
	public void run() {
		boolean temp = true;
		int input;
		while(temp) {
			menu.printMainMenu();
			input = menu.scanInt();
			if (input == -1) {
				menu.print("Program terminated.");
				temp = false;
			}
			else if (input > 0 && input < 6) {
				this.process(input);
			}
		}
	}
	
	public void process(int processInput) {
		if (processInput == 1) {
			saveText();
		}
		else if (processInput == 2) {
			correct();
		}
		else if (processInput == 3) {
			count();
		}	
		else if (processInput == 4) {
			search();
		}
		else if (processInput == 5) {
			doAll();
		}
		else {
			this.menu.print("Invalid process number: ");
		}
	}
	
	public void correct() {
		int subProcessNumber;
		this.menu.printSubMenu();
		subProcessNumber = this.menu.scanInt();
		if (subProcessNumber == 1) {
			correctFromFile();
		}
		else if (subProcessNumber == 2) {
			correctFromConsole();
		}	
		else {
			this.menu.print("Invalid process number.");
		}
	}
	
	public void count() {
		int subProcessNumber;
		this.menu.printSubMenu();
		subProcessNumber = this.menu.scanInt();
		if (subProcessNumber == 1) {
			countFromFile();
		}
		else if (subProcessNumber == 2) {
			countFromConsole();
		}
		else {
			this.menu.print("Invalid process number.");
		}
	}
	
	public void search() {
		int subProcessNumber;
		this.menu.printSubMenu();
		subProcessNumber = this.menu.scanInt();
		if (subProcessNumber == 1) {
			searchFromFile();
		}
		else if (subProcessNumber == 2) {
			searchFromConsole();
		}
		else {
			this.menu.print("Invalid process number.");
		}
	}
	
	public void doAll() {
		int subProcessNumber;
		this.menu.printSubMenu();
		subProcessNumber = this.menu.scanInt();
		if (subProcessNumber == 1) {
			doAllOperationToFile();
		}
		else if (subProcessNumber == 2) {
			doAllOperationToFile();
		}
		else {
			this.menu.print("Invalid process number.");
		}
	}
	
	public void saveText() {
		this.menu.print("Enter a text to save file: ");
		String input = this.menu.scanString();
		consoleText = new ConsoleText(input);
		textSaver.operation(consoleText);
	}
	
	public void correctFromFile() {
		this.menu.print("Enter your file name from desktop to correct: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName));
		autoCorrector.operation(fileText);
		textSaver.operation(fileText);
	}
	
	public void correctFromConsole() {
		this.menu.print("Enter a text to correct: ");
		String input = this.menu.scanString();
		consoleText = new ConsoleText(input);
		autoCorrector.operation(consoleText);
		this.menu.print(consoleText.getValue());
		textSaver.operation(consoleText);
	}
	
	public void countFromFile() {
		this.menu.print("Enter your file name from desktop to count paragraphs, lines, words and characters: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName));
		counter.operation(fileText);
	}
	
	public void countFromConsole() {
		this.menu.print("Enter a text to count paragraphs, lines, words and characters: ");
		String input = this.menu.scanString();
		consoleText = new ConsoleText(input);
		counter.operation(consoleText);
	}
	
	public void searchFromFile() {
		this.menu.print("Enter your file name from desktop to search: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName));
		this.menu.print("Enter characters to search: ");
		String characters = this.menu.scanString();
		fileText.setCharacter(characters);
		searcher.operation(fileText);
	}
	
	public void searchFromConsole() {
		this.menu.print("Enter a text to search: ");
		String input = this.menu.scanString();
		consoleText = new ConsoleText(input);
		this.menu.print("Enter characters to search: ");
		String characters = this.menu.scanString();
		consoleText.setCharacter(characters);
		searcher.operation(consoleText);
	}
	
	public void doAllOperationToFile() {
		this.menu.print("Enter your file name from desktop to do all operations at once: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName));
		composite.operation(fileText);
	}
	
	public void doAllOperationToConsole() {
		this.menu.print("Enter a text to do all operations at once: ");
		String input = this.menu.scanString();
		consoleText = new ConsoleText(input);
		composite.operation(consoleText);
	}
}
