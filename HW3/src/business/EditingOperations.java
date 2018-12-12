package business;

import java.io.File;
import java.io.FileNotFoundException;

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
		((Composite) composite).addOperation(textSaver);
		((Composite) composite).addOperation(autoCorrector);
		((Composite) composite).addOperation(counter);
		((Composite) composite).addOperation(searcher);
	}
	
	//running TextCorrectionApp
	public void run() {
		boolean temp = true;
		int input;
		this.menu.printAppUsage();
		while(temp) {
			this.menu.printMainMenu();
			input = this.menu.scanInt();
			if (input == -1) {
				this.menu.print("Program terminated.");
				temp = false;
			}
			else if (input > 0 && input < 6) {
				this.process(input);
			}
			else {
				this.menu.print("Invalid process.");
			}
		}
	}
	
	//processing input given by user via console
	public void process(int processInput) {
		if (processInput == 1) {
			saveTextToFile();
		}
		else if (processInput == 2) {
			correctFile();
		}
		else if (processInput == 3) {
			countFile();
		}	
		else if (processInput == 4) {
			searchFile();
		}
		else if (processInput == 5) {
			doAllOperation();
		}
		else {
			this.menu.print("Invalid process number: ");
		}
	}		
	
	//saves the given text to the file ("GivenText.txt")
	public void saveTextToFile() {
		this.menu.printAppUsage();
		this.menu.print("WARNING: Please enter your text according to usage definition!");
		this.menu.print("Enter a text to save file: ");
		String inputText = this.menu.scanMultipleLines();
		
		this.menu.print("Enter a filename with its extension: ");
		String fileName = this.menu.scanString();
		consoleText = new Text(inputText, fileName);
		
		textSaver.operation(consoleText);
	}
	
	//correcting text that determined from a file
	public void correctFile() {
		this.menu.printAppUsage();
		this.menu.print("WARNING: If you did not save your file via this app please design your file text according to usage definition!");
		this.menu.print("Enter your file name with its extension from desktop to correct: ");
		String fileName = this.menu.scanString();
		String correctedFileName = "Corrected"+ fileName;
		File f = new File(System.getProperty("user.home") + "/Desktop/" + fileName);
		
		//if file doesn't exist it returns to menu
		if(!f.exists()) { 
		    System.out.println("FILE NOT FOUND\n");
		    return;
		}
		
		fileText = new Text(fileOperations.readFromFile(fileName), correctedFileName);
		
		autoCorrector.operation(fileText);
		textSaver.operation(fileText);
		
		this.menu.print("--- Corrected Text ---");
		this.menu.print(fileText.getValue());
		this.menu.print("----------------------");
	}

	//counting from a file
	public void countFile() {
		this.menu.printAppUsage();
		this.menu.print("WARNING: If you did not save your file via this app please design your file text according to usage definition!");
		this.menu.print("Enter your file name with its extension from desktop to count paragraphs, lines, words and characters: ");
		String fileName = this.menu.scanString();
		File f = new File(System.getProperty("user.home") + "/Desktop/" + fileName);
		
		//if file doesn't exist it returns to menu
		if(!f.exists()) { 
		    System.out.println("FILE NOT FOUND\n");
		    return;
		}
		fileText = new Text(fileOperations.readFromFile(fileName), fileName);
		
		counter.operation(fileText);
	}
	
	//searching from file
	public void searchFile() {
		this.menu.printAppUsage();
		this.menu.print("WARNING: If you did not save your file via this app please design your file text according to usage definition!");
		this.menu.print("Enter your file name with its extension from desktop to search: ");
		String fileName = this.menu.scanString();
		File f = new File(System.getProperty("user.home") + "/Desktop/" + fileName);
		
		//if file doesn't exist it returns to menu
		if(!f.exists()) { 
		    System.out.println("FILE NOT FOUND\n");
		    return;
		}
		fileText = new Text(fileOperations.readFromFile(fileName), fileName);
		
		this.menu.print("Enter characters to search: ");
		String characters = this.menu.scanString();
		fileText.setCharacter(characters);
		
		searcher.operation(fileText);
	}
	
	//applying all operations to console input
	public void doAllOperation() {
		this.menu.printAppUsage();
		this.menu.print("WARNING: Please enter your text according to usage definition!");
		this.menu.print("Enter a text to do all operations at once: ");
		String input = this.menu.scanMultipleLines();
		
		this.menu.print("Enter a filename with its extension: ");
		String fileName = this.menu.scanString();
		
		this.menu.print("Enter characters to search: ");
		String characterInput = this.menu.scanString();

		consoleText = new Text(input, fileName);
		consoleText.setCharacter(characterInput);
		
		composite.operation(consoleText);
		
		this.menu.print("--- Corrected Text ---");
		this.menu.print(consoleText.getValue());
		this.menu.print("----------------------");
		
		String correctedFileName = "Corrected" + fileName;
		this.fileOperations.writeToFile(consoleText.getValue(), correctedFileName);
	}
}
