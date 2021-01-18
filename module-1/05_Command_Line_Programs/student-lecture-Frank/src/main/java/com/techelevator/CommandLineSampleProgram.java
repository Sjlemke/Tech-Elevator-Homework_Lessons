package com.techelevator;

import java.util.Scanner;

public class CommandLineSampleProgram {

	public static void main(String[] args) {		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		
		Scanner userInput = new Scanner(System.in);
		
		String aLine = "";
		System.out.println("Please enter a line: ");

		aLine = userInput.nextLine();
				
		System.out.println("You entered the line: " + aLine);
		
		System.out.println("enter a whole number: ");
		aLine = userInput.nextLine();
		System.out.println("entered the number: " + aLine);
		
		System.out.println("half of that number is: " + theNumber / 2);
	}

}
