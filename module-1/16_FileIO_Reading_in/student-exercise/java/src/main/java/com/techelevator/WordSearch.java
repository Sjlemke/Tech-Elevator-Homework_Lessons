package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
		File aliceFile = new File("./alices_adventures_in_wonderland.txt");
		Scanner WordSearch = new Scanner(aliceFile);
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the search word you are looking for");
		String userInput = keyboard.nextLine();
		System.out.println("Do you want it case sensitive? Y/N");
		String caseInput = keyboard.nextLine();
	    keyboard.close();

		
	 
	    
	    int counter = 1;
	   
	    if(caseInput.contains("Y") || caseInput.contains("y")) {
	    	while(WordSearch.hasNext()) {
	    		String aLine = WordSearch.nextLine();
	    		if(aLine.contains(userInput)) {
	    			System.out.println(counter + ") " + aLine);
	    		}
	    		counter ++;
	    	}
	    } else {
	    	while (WordSearch.hasNext()) {
	    		String aLine = WordSearch.nextLine();
	    		if (aLine.toLowerCase().contains(userInput.toLowerCase())) {
	    			System.out.println(counter + ") " + aLine);
	    		}
	    		counter ++;
	    	}
	    }
	    
	    
		
	keyboard.close();
	WordSearch.close();
	}
}
//search a string for another string. look for a string method for this? does one string 
//contain another string? If so, print out. Add case insensitivity. 
//create my own file with just a few lines in it just to test it first then, do the 4,000 one.
//run a test file? 