package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//this program will validate bank routing numbers stored in a file. The file used is called rtn.text. 
public class RTNValidator { //this file is called rtn.txt.
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner(); //you want to instantiate a file object for hte path returned from getInputFileFromUser() Method
		                          //Display a polite hello message.
		//if you try to read more lines than in the file an Exception is thrown. program terminates with a message.
		File inputFile = getInputFileFromUser(); //define a file object for the file. We get the file path from a method.
		try(Scanner fileScanner = new Scanner(inputFile)) { //define a scanner objecr for the file
			while(fileScanner.hasNextLine()) {        //while loop through the file as long as there is data in the file/has a line. hasNextLine does this
				String line = fileScanner.nextLine();  //loop while a condition is true. thats why we use while because we dont know how much data is in it. 
				String rtn = line.substring(0, 9);     //get the next line from the file. Extract first 9 characters as t he rtn. 
				
				if(checksumIsValid(rtn) == false) {   //pass the rtn to the validation method. 
					System.out.println(line);          //if the rtn was valid - display it.
				}
			
			} fileScanner.close(); //close the file to release used to process
		}   
		}  // end of main()
	    
	//hard code value the file in teh real world.> 
	File inputFile = new File("rtun.txt"); // identifies the path as a string literal
	
	
	  //instatiating the Scanner object in a try() causes it to be automatically close at the end of the program.  
	//try(Scanner fileScanner = new Scanner(inpuitFiler); If you define the scanner object yourself you are to close it at the end. Leaving a file open at the end of the program cause a resource leak.
	 // resource leak: is when resources (memory) used by the program are not freed at the end of the program. Can lead to slower processing unexpected errors or computer just stopping.
	

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	//this method will get a path from a user, if its valid, return a file object for hte path.
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);  //instantiate an object for the keyboard
		System.out.print("Please enter path to input file >>> "); //display a user prompt for the input needed
		String path = userInput.nextLine(); //get a line of input from the keyboard
		                      //check to be sure what the user entered was a valid existing path to a file.
		File inputFile = new File(path); //instantiate a file object for the path entered by the user
		if(inputFile.exists() == false) { // checks for the existence of a file. Does the path given not exist? if so display message and end program
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {    //Was the path given not a file?
			System.out.println(path+" is not a file"); // if so, display a message
			System.exit(1); // Ends the program                          //and ends the program with a return code 1
		}
		return inputFile;  //return the file object for the path
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
