package com.techelevator.Bowling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class League {
	
	private String leagueName; 
	public Map<Integer, Bowler> leagueMembers;    //the instructions said it wanted to ASSOCIATE the bowler with the team. and wants a SET
                       //<key,value>   key is the team Number/Integer, and value is bowler.
	//create a default constructor which is always public 
	public League() {
		leagueName = null;
		leagueMembers = null; 
	}
		
		//now they want a 2 arg constructor, 
	public League(String leagueName, String dataFileName) throws FileNotFoundException {
		this.leagueName = leagueName; //this. is required because the param has the same name as the data number
	                              //load data from the file given into leagueMembers using number function
		loadFile(dataFileName);   //run the loadFile method sending the file to be loaded
	}
	   private void loadFile(String fileNameToLoad) throws FileNotFoundException {  //creating a seperate method to load file given into leagueMembers. Its private because we dont want users to be able to run it.
		File aFile = new File(fileNameToLoad);  //define a file object for the file   
	   Scanner inputDataFile = new Scanner(aFile); //Define a scanner when you want to read a file for the file object
	  
	   //define variabled to hold data from file
	   int teamNumber = 0; 
	   int bowlerNumber = 0;
	   String bowlerName = null;
	   ArrayList<Integer> scores = new ArrayList<Integer>(); 
	   
	   while(inputDataFile.hasNext()) {
		  String aLine = inputDataFile.nextLine();
		  String[] valueInLine = aLine.split(",");
	//Define the variables needed to create/instantiate a bowler. 	  
//assign the values from the file into three variables
		  int teamNumber = Integer.parseInt(valuesInLine[0]);  //converting string to Int. 
		  int bowlerNumber = Integer.parseInt(valuesInLine[1]);  //converting string to Int.
		  String bowlerName = valuesInLine[2]; //store the 3rd value from the line. Getting data out of the array.
		  
		  ArrayList<Integer> scores = new ArrayList<>(); //define a place to hold the scores.
		  
		  scores.add(Integer.parseInt(valuesInLine[3]));  //convert first score to an int and add it to arraylist
		  scores.add(Integer.parseInt(valuesInLine[4]));  //convert the second score to an int and add to arraylist.
	   }  //we have all the data from the file stored in variables. 
	      //We can define a Bowler 
	     
	   
	      Bowler aBowler = new Bowler(teamNumber, bowlerNumber, bowlerName, scores); //Unfinished. 
	       //create an ArrayList of bowlers and add it to Map using the teamNumber to the key
	   }
}


