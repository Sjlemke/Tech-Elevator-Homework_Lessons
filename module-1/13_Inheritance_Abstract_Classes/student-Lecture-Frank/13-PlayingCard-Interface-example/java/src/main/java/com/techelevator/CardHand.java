package com.techelevator;

import java.util.ArrayList;
//Define the behaviors that must be implemented to be considered a CardHand

public interface CardHand {  //If you want to be considered a CardHand you must define these methods(behaviors)
	
	public ArrayList<PlayingCard> getHand();  //returns the cards in the hand as an Arraylist

	public void addCard(PlayingCard aCard); //receive a PlayingCard and add it to the hand
	
	public void emptyHand(); //empty/remove all PlayingCards from the hand

	public void show(); //display all the cards in the hand

}
