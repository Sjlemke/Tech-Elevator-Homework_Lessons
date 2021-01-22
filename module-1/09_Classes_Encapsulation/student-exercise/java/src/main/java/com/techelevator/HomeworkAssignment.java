package com.techelevator;

public class HomeworkAssignment {
	
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	//ctor - 2 args constructor
	public HomeworkAssignment(int possibleMarks, String submitterName) {
	   this.possibleMarks = possibleMarks;   //set data member to teh parameter 
	   this.submitterName = submitterName; 
	}
	public String getLetterGrade() {  //**CANT INT / INT...SO double / int **
		String letterGrade = "";    //hold the letter grade to be returned
		double grade = (double)earnedMarks / possibleMarks;  //  wants percentage of earned marks and possible marks. Use "/" for average/divide  
		      if (grade >= 0.90) {
		    	letterGrade = "A";   //members of the class can access private data
		      }
		      else if (grade >= .80) {
		    	letterGrade = "B";
		       }
		      else if (grade >= .70) {
		        letterGrade = "C";
		       }
		      else if (grade >= .60) {
 		    	   letterGrade = "D";
 		       }
 		       else {
 		    	   letterGrade = "F";
 		       }
		return letterGrade;                         //derived means method determines and returns it/lettergrade.
	}
}
//method to determine derived value letterGrade. LetterGrade should return a String and should be called 
//getLetterGrade() {
//make it public so anyone can access this method. Most methods i write will be public. 
//getletterGrade will take no arguments. Define the return value
