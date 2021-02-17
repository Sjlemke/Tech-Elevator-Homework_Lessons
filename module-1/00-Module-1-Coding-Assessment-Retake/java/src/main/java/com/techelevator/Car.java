package com.techelevator;


public class Car {
	
	private int year; 
	public String make;
	public boolean isClassicCar; 
	public int age;
	public int yearToCheck; 

	
	public Car(int year, String make, boolean isClassicCar) {
		    this.year = year;  
		    this.make = make;
		    this.isClassicCar = true;
	}
	
    public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public boolean isClassicCar() {
		return isClassicCar;
	}

	public void setClassicCar(boolean isClassicCar) {
		this.isClassicCar = isClassicCar;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


public boolean YearToCheck() {
		 if(year % 2 == 0 ) {
		 return true;
		    	
		 if(year % 2 != 0 ) {
		 return true;
			}
               
		    	}	
		    }
 public boolean age() {
		 if(age < 4 || age > 25) {
		 return false;  
		    }
 	    
 }
