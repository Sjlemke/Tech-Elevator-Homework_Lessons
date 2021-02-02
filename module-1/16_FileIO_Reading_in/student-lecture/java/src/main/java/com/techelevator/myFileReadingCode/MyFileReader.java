package com.techelevator.myFileReadingCode;
import java.io.File; //include the code to support java file i/o
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		//read the data from a file containing lines of numbers seperated by commas
		//Display the line we read from hte file the file 
		//Sum the numbers 
		//Average the numbers
		//print the sum and the average
		int sum = 0;  //hold the sum of the numbers
		double average = 0;  //hold the average of the numbers
		//1. Instantiate a file object for the file containing the data.
		File theFile = new File("./data/numbers.txt"); //correct path to data
		
		//Instatiate a Scanner object for the file
		Scanner fileReader = new Scanner(theFile);
		
		//Loop through the file one line at a time. Always going to be a while loop
		while(fileReader.hasNext()) { // as lomg as file has a next line to read, we are gonna get it.
		String aLine = fileReader.nextLine();  //Get the next line from the file
		System.out.println("The line read: " + aLine); //Display line from file. You dont HAVE to do this.
		String[] theNumbers = aLine.split(",");   //Split the line based on a comma
		for (int i = 0; i <theNumbers.length; i++) {  //loop through String number values one at a time
			int aNumber = Integer.parseInt(theNumbers[i]);  //convert the current element in theNumber to an Int
		    sum += aNumber;
		}
		System.out.println("Sum: " + sum + " avg:" + average);
		}
		fileReader.close(); //close the Scanner to avoid a resource leak.
}  // end of main()
}