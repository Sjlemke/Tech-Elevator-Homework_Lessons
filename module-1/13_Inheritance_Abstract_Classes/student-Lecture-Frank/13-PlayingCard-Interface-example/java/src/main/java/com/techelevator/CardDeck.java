package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
   // simulate a deck of PlayingCards

public class CardDeck {
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;
    //LinkedList is Queue - FIFO out Collection - first item in is the first item out

	public CardDeck() {
		resetDeck(true); // reset deck with jokers
	}
	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() {
		if (deckOfCards.size() > 0) {   //As long as there are cards in the deck
			return deckOfCards.remove();  //return the top/first card and remove it from the queue
		}
		else {
			 return null; //if no cards in the deck
		}
	}

	public void resetDeck(boolean withJoker) {
		deckOfCards.clear(); //remove all cards in the deck

		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}  //Add all the clubs to the deck
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {  //add all the hearts to the deck
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {  //add all the diamonds to the deck
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {  //if they want jokers in the deck, add them.
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() {   //this shuffles the cards
		resetDeck(false);         //give me new deck of cards without jokers
		Collections.shuffle(deckOfCards); //use the collections class shuffle method to randomize cards
	}

}