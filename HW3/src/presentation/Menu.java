package presentation;

import java.util.Scanner;

public class Menu {
	
	private Scanner s;
	
	public Menu() { }
	
	public void printMainMenu() {
		System.out.println("--------------------------- Enter a process number ---------------------------");
		System.out.println("1. Save input to a file.\n");
		System.out.println("2. Correct text automatically.\n");
		System.out.println("3. Count number of paragraph, line, word, and "
				+ "characters of a given text.\n");
		System.out.println("4. Search characters in a text.\n");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public void printCorrectionMenu() {
		System.out.println("---------- Choose whether you want to correct from a file or console ---------");
		System.out.println("1. From file.\n");
		System.out.println("2. From console.\n");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	
	public void print(int i) {
		System.out.println(i);
	}
	
	public String scanString() {
		this.s = new Scanner(System.in);
		return s.nextLine();
	}
	
	public int scanInt() {
		int i = 0;
		boolean isInt = false;
		this.s = new Scanner(System.in);
		
		while(isInt) {
			try {
				i = Integer.parseInt(s.nextLine());
			} 
			catch (Exception e) {
				System.out.println("Please enter a number.\n");
			}
		}
		return i;
	}

}
