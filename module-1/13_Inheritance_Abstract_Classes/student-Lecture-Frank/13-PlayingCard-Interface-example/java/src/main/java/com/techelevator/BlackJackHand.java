package com.techelevator;

import java.util.ArrayList; //a blackjack hand is a type of cardhand.
                           //"type of" == interface

public class BlackJackHand	 implements CardHand {

	private int numCardsInHand = 2; //starting number of cards in hand
	
	private ArrayList<PlayingCard> aHand; //represent the hand as ArrayList
	
	public BlackJackHand() {
		aHand = new ArrayList<PlayingCard>(numCardsInHand);
	}
	// we need to override the methods that are required by the cardhand interface.
	//
	@Override
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);  //use the ArrayList add() to add a card to the hand
		numCardsInHand++;
	}

	@Override
	public void emptyHand() {
		aHand.clear(); //use the ArrayList clear() to empty the hand

	}

	@Override
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	//Methods to provide additional functionality beyond what is required by the CardHand interface
	//do not code Override to ask the compiler to verify they are proper overrides since they are not overrides.
	public void dealHand(CardDeck aDeck) {
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
