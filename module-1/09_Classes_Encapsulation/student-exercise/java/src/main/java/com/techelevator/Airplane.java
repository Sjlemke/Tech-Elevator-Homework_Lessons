package com.techelevator;

public class Airplane {
	
	private String PlaneNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;

	public Airplane(String planeNumber,int totalFirstClassSeats, int totalCoachSeats) {
		PlaneNumber = planeNumber; 
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		bookedFirstClassSeats = 0;
	    bookedCoachSeats = 0;
	    
	    availableCoachSeats = totalCoachSeats;
	    availableFirstClassSeats = totalFirstClassSeats;
	}

	public String getPlaneNumber() {
		return PlaneNumber;
	}
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
	}
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	public int getAvailableCoachSeats() {
		return availableCoachSeats;
	}
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass && totalNumberOfSeats <= availableFirstClassSeats)
		 {
		availableFirstClassSeats -= totalNumberOfSeats;
		bookedFirstClassSeats += totalNumberOfSeats;
		return true;
		}
		else if(!forFirstClass && totalNumberOfSeats <= availableCoachSeats) {	
		availableCoachSeats -= totalNumberOfSeats;	
		bookedCoachSeats += totalNumberOfSeats;
		return true;
		}
		return false;
	}
	
	}
