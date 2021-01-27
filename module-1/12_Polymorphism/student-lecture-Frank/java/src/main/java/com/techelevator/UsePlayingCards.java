package com.techelevator;

import java.util.ArrayList;

public class UsePlayingCards {

	public static void main(String[] args) {
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard();

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "JASON");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard();
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "JASON");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard();
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JASON");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();	
		
		
		// start of the polymorphism examples 
		
		System.out.println("\n--exaamples start here ---\n");
		
		PlayingCard aCard = null;  // define a superclass that is empty
		
		aCard = aUSACard;   //assign a sub class to a super class variable
		                   //normally you cannot assign an object of one class to an object of another class
		                   //inheritance let you assign a subclass to a super call variable
		                   // so you can take advantage of polymorph. Pm requires inheritence. the variable must of tje superclass type but variable from subclass.
		aCard.showCard();   //use super class object to run a common method in the inheritence heirarchy
		                    //All subclass have a showCard() method - Poly 
		aCard = aSwissCard1;
		aCard.showCard();
		
		aCard = anItalianCard1;
		aCard.showCard();
		
		System.out.println("\n ---- poly examples using ArrayList ---\n");
		
		ArrayList<PlayingCard> cardList = new ArrayList();
	    // define a collection class object or a regular array with the data type of the superclass
		// you have a group of super class objects.
		//add subclass objects to the ArrayList();
		
	   cardList.add(aSwissCard1); //add subclass object
	   cardList.add(anItalianCard1);  //add a subclass object
	   cardList.add(aUSACard);   //add a subclass oject
	   
	   //loop through the ArrayLst displaying the cards using the showCard() method
	   for(PlayingCard theCard : cardList ) { //use the super class for the four-each variable
		   aCard.showCard();    //use the for-each variable to invoke the method
	   }
	   
	   // bc of the ply we dont need to know or care what type of object is in the for-loop
	   //variable each time through the loop.
	} // end of main() method

	
	
	
} //end of the application program class. 
