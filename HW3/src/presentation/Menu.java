package presentation;

import java.util.Scanner;

public class Menu {
	
	public Menu() { }
	
	public void printConsoleInputSettings() {
		System.out.println("--------------------------- CONSOLE INPUT SETTINGS ---------------------------");
		System.out.println("Please type 'Enter' after you finish entering your input.");
		System.out.println("1. A paragraph must have 'tab' at the beginning of it.");
		System.out.println("2. A line must have 'enter' at the end of it.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public void printFileInputSettings() {
		System.out.println("--------------------------- FILE INPUT SETTINGS ---------------------------");
		System.out.println("1. A paragraph must have 'tab' at the beginning of it.");
		System.out.println("2. A line must have 'enter' at the end of it.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public void printInputSettings() {
		System.out.println("--------------------- WELCOME TO OUR AUTO CORRECTION APP --------------------");
		System.out.println();
	}
	
	//printing main menu
	public void printMainMenu() {
		System.out.println("--------------------------- Enter a process number ---------------------------");
		System.out.println("-1 to terminate program.");
		System.out.println("1. Save input to a file.");
		System.out.println("2. Correct text automatically.");
		System.out.println("3. Count number of paragraph, line, word, and "
				+ "characters of a given text.");
		System.out.println("4. Search characters in a text.");
		System.out.println("5. Do all operations at once.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	//printing sub menu
	public void printSubMenu() {
		System.out.println("--------------------------- Choose your input type ---------------------------");
		System.out.println("1.From file.");
		System.out.println("2.From console.");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	//printing to the console
	public void print(String s) {
		System.out.println(s);
	}
	
	//printing to the console
	public void print(int i) {
		System.out.println(i);
	}
	
	//getting input from user via console
	public String scanString() {
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}
	
	//getting multiple lined input from user via console
	public String scanMultipleLines() {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		StringBuilder output = new StringBuilder();
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.length() == 0) {
				break;
			}
			output.append(line).append("\n");
		}
		return output.toString();
	}
	
	//getting input from user via console
	public int scanInt() {
		int number=-1;
		Scanner s = new Scanner(System.in);
		boolean isInt = false;
		while(isInt == false) {
			try {
				number = Integer.parseInt(s.nextLine()); 
				isInt = true ;
			} catch (Exception e) {
				System.out.println("Invalid Value");
				System.out.println("Please enter a Number \n");
			}
		}
		return number;	
	}

}
