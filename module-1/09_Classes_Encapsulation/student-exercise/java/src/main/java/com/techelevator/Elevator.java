package com.techelevator;

public class Elevator {
	
	private int currentFloor =1;
	private int numberOfFloors = 0;
	private boolean doorOpen = false;

public Elevator(int floors) {
	numberOfFloors = floors;
}
public int getCurrentFloor() {
	return currentFloor;
}

public boolean isDoorOpen() {
	return doorOpen;
}

public int getNumberOfFloors() {
	return numberOfFloors;
}
 public void openDoor() {
	 doorOpen = true; 
	 }
 
 public void closeDoor() {
	 doorOpen = false;
 }
 public void goUp(int desiredFloor) {
	 if (!doorOpen && desiredFloor > currentFloor) {
		 currentFloor = desiredFloor;
		 if (currentFloor >= numberOfFloors)
			 currentFloor = numberOfFloors;
	 }
 }
 public void goDown(int desiredFloor) {
	 if (!doorOpen && desiredFloor < currentFloor) {
		 currentFloor = desiredFloor; 
		  if (currentFloor <= 1) {
		  currentFloor = 1;
		  }
			  
 }
 
}
}