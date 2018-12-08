package presentation;

import java.util.Scanner;

public class Menu {
	
	private Scanner s;
	
	public Menu() { }
	
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
		this.s = new Scanner(System.in);
		return s.nextLine();
	}
	
	//getting input from user via console
	public int scanInt() {
		int number=-1;
		Scanner input = new Scanner(System.in);
		boolean isInt = false;
		while(isInt == false) {
			try {
				number = Integer.parseInt(input.nextLine()); 
				isInt = true ;
			} catch (Exception e) {
				System.out.println("Invalid Value");
				System.out.println("Please enter a Number \n");
			}
		}
		return number;	
	}

}
