package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 
    int score1 = 10;
    int score2 = 20;
    int score3 = 30;
    int score4 = 50;
    
    int sum = 0;
    double avg = 0.0;
    
    sum = score1 + score2 + score3;
    avg = sum / 4;
    
    System.out.println("Sum of scores: " + sum);
    System.out.println("Avg of scores: " + avg);
	}   
   
}