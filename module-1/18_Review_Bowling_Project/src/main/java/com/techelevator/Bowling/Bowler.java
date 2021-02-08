package com.techelevator.Bowling;

import java.util.ArrayList;

public class Bowler {

	private int teamNumber; 
	public int bowlerNumber;
	public String bowlerName; 
	private ArrayList<Integer> scores;
	
	public Bowler(int teamNumber, int bowlerNumber, String bowlerName, ArrayList<Integer> scores) {
		    this.teamNumber = teamNumber;  //we need this to reference the data number since paramet name is the same
		    this.bowlerNumber = bowlerNumber;
		    this.bowlerName = bowlerName;
		    this.scores = scores;
		    
	}
	  //constructors initialize the attributes. Constructor must be same name as the Class
	  // which is Bowler in this case. this is a 4 argument constructor with values passed from the user.
      //generate getters and setters for all with source/generate/
	//Define methods to get derived values 
	
	public int getTeamNumber() {
		return teamNumber;
	}

	
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getBowlerNumber() {
		return bowlerNumber;
	}

	public void setBowlerNumber(int bowlerNumber) {
		this.bowlerNumber = bowlerNumber;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}
	@Override    //source, generate toString
	public String toString() {
		return "Bowler [teamNumber=" + teamNumber + ", bowlerNumber=" + bowlerNumber + ", bowlerName=" + bowlerName
				+ ", scores=" + scores + "]";
	}
	
	//define methods to get derived method. The method to return the sum of the scores as an int
	//method names for derived values are usually prefixed with the word "get" followed
	//by the name of the derived value. (we used getSum() here)
	
	public int getSum() {  //the the data we need is in the class, so no params are needed.
	int sum = 0;  //define a variable for the return value
	for(int i = 0; i < scores.size(); i++)   {                 //loop through the array list of scores.
	sum = sum + scores.get(i);  //add the current element to the sum
	}
	return sum; //return the variable with the result
	}
	 //now we need the method to get hte average of the scores. make it a double
	public double getAverage() {   //all the data we need is in this class. so no params for method are needed.
	   double avg = 0;  //define variable to hold a result
	   avg = this.getSum () / scores.size();                   //to determine average we need to divide the sum of the scores by the number of scores
	   return avg;  //return the result 
	       //alternative way to write that >> return this.getSum() / scores.size();
	}
	
	@Override
	public int hashCode() {    //source, generate hashmap
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bowlerName == null) ? 0 : bowlerName.hashCode());
		result = prime * result + bowlerNumber;
		result = prime * result + ((scores == null) ? 0 : scores.hashCode());
		result = prime * result + teamNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bowler other = (Bowler) obj;
		if (bowlerName == null) {
			if (other.bowlerName != null)
				return false;
		} else if (!bowlerName.equals(other.bowlerName))
			return false;
		if (bowlerNumber != other.bowlerNumber)
			return false;
		if (scores == null) {
			if (other.scores != null)
				return false;
		} else if (!scores.equals(other.scores))
			return false;
		if (teamNumber != other.teamNumber)
			return false;
		return true;
	}
}
