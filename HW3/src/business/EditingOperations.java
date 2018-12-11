package business;

import dataaccess.FileOperations;
import presentation.Menu;

public class EditingOperations {

	//declaring all operations
	private Component textSaver;
	private Component autoCorrector;
	private Component counter;
	private Component searcher;
	private Component composite;
	
	//declaring menu and fileOperations
	private Menu menu;
	private FileOperations fileOperations;
	
	//declaring texts
	private Text consoleText;
	private Text fileText;
	
	public EditingOperations() {
		//creating operations
		textSaver = new TextSaver();
		autoCorrector = new AutoCorrector();
		counter = new Counter();
		searcher = new Searcher();
		composite = new Composite();
		
		//creating menu and fileOperations
		menu = new Menu();
		fileOperations = new FileOperations();
		
		//adding operations to the composite
		((Composite) composite).addOperation(autoCorrector);
		((Composite) composite).addOperation(counter);
		((Composite) composite).addOperation(textSaver);
	}
	
	//running TextCorrectionApp
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
			else {
				menu.print("Invalid process.");
			}
		}
	}
	
	//processing input given by user via console
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
	
	//correcting given text
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
	
	//counting number of paragraphs, lines, words and characters in given text
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
	
	//searching if given characters are in the given text 
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
	
	//applying all operations inside composite (Auto correction, counting, saving to the file)
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
	
	//saves the given text to the file ("GivenText.txt")
	public void saveText() {
		this.menu.printConsoleInputSettings();
		this.menu.print("Enter a text to save file: ");
		String input = this.menu.scanMultipleLines();
		consoleText = new ConsoleText(input, "ConsoleText.txt");
		textSaver.operation(consoleText);
	}
	
	//correcting text that determined from a file
	public void correctFromFile() {
		this.menu.printFileInputSettings();
		this.menu.print("Enter your file name with its extension from desktop to correct: ");
		String fileName = this.menu.scanString();
		String correctedFileName = "Corrected"+ fileName;
		fileText = new FileText(fileOperations.readFromFile(fileName), correctedFileName);
		autoCorrector.operation(fileText);
		textSaver.operation(fileText);
	}
	
	//correcting text that determined from console
	public void correctFromConsole() {
		this.menu.printConsoleInputSettings();
		this.menu.print("Enter a text to correct: ");
		String input = this.menu.scanMultipleLines();
		consoleText = new ConsoleText(input, "Default.txt");
		autoCorrector.operation(consoleText);
		this.menu.print(consoleText.getValue());
		consoleText.setFileName("CorrectedConsoleText.txt");
		textSaver.operation(consoleText);
	}
	
	//counting from a file
	public void countFromFile() {
		this.menu.printFileInputSettings();
		this.menu.print("Enter your file name with its extension from desktop to count paragraphs, lines, words and characters: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName), fileName);
		counter.operation(fileText);
	}
	
	//counting from console
	public void countFromConsole() {
		this.menu.printConsoleInputSettings();
		this.menu.print("Enter a text to count paragraphs, lines, words and characters: ");
		String input = this.menu.scanMultipleLines();
		consoleText = new ConsoleText(input, "Default.txt");
		counter.operation(consoleText);
	}
	
	//searching from file
	public void searchFromFile() {
		this.menu.printFileInputSettings();
		this.menu.print("Enter your file name with its extension from desktop to search: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName), fileName);
		this.menu.print("Enter characters to search: ");
		String characters = this.menu.scanString();
		fileText.setCharacter(characters);
		searcher.operation(fileText);
	}
	
	//searching from console
	public void searchFromConsole() {
		this.menu.printConsoleInputSettings();
		this.menu.print("Enter a text to search: ");
		String input = this.menu.scanMultipleLines();
		consoleText = new ConsoleText(input, "Default.txt");
		this.menu.print("Enter characters to search: ");
		String characters = this.menu.scanString();
		consoleText.setCharacter(characters);
		searcher.operation(consoleText);
	}
	
	//applying all operations to a file
	public void doAllOperationToFile() {
		this.menu.printFileInputSettings();
		this.menu.print("Enter your file name with its extension from desktop to do all operations at once: ");
		String fileName = this.menu.scanString();
		fileText = new FileText(fileOperations.readFromFile(fileName), "Corrected" + fileName);
		composite.operation(fileText);
	}
	
	//applying all operations to console input
	public void doAllOperationToConsole() {
		menu.printConsoleInputSettings();
		this.menu.print("Enter a text to do all operations at once: ");
		String input = this.menu.scanMultipleLines();
		consoleText = new ConsoleText(input, "CorrectedConsoleText.txt");
		composite.operation(consoleText);
	}
}
