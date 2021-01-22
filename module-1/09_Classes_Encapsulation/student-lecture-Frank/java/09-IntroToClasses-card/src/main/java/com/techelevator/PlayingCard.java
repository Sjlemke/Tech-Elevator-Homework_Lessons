package com.techelevator;

public class PlayingCard {
	 //This is a class to represent a Playing Card
	 //
	 // A class has data (variables) and behaviors (methods)
	 //
	 // We have identified the following characteristics for a Playing Card:
	 //
//	      value
//	      suit
//	      color
//	      shape
//	      face up / face down
	 //
	 // The characteristics or data for a class may also be called attributes
	 //
	 // The attributes for a class are defined as member variables
	 // A variable is a "member variable" if it's defined in a class
	 //
	 // To define a member variable: access - public  - any one access it
//	                                        private - only members of the class can access it
//	                               datatype
//	                               name
	 //
	 // using private on variables implements encapsulation
	 // encapsulation means we are protecting the data from access outside the class
	
	private int     cardValue; // Ace=1, Jack=11, Queen=12, King=13
	private String  cardSuit;
	private String  cardColor;
	private String  cardShape;
	private boolean faceUp;
	@Override
	
	
	public String toString() {
		return "PlayingCard [cardValue=" + cardValue + ", cardSuit=" + cardSuit + ", cardColor=" + cardColor
				+ ", cardShape=" + cardShape + ", faceUp=" + faceUp + "]"; 
	}
		//every class should provide constructor methods to initialize objects to the class. If constructors are not provided Java runs
		//a default constructor(ctor) to initialize object. The Java default contructor is gonna set objects = null, numerics = 0, and booleans to false.
		// since we did not provide a ctor so it ran default. Card value was 0, strings were null. Ctors are special methods in a class. 
		//ctors are special because there is no return type (not even void) name is same name as the class.
		//define default constructor for this class. 
		
		public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	public String getCardShape() {
		return cardShape;
	}

	public void setCardShape(String cardShape) {
		this.cardShape = cardShape;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

		PlayingCard() {    
		cardValue = 13;
		cardColor = "Red";
		cardSuit = "Diamonds";
		cardShape = "circle";
		faceUp = true;
		}
	
		//To allow a user to define any PlayingCard we need to create a ctor that takes parameters for the data values
		
		

		PlayingCard(int value, String color, String suit) {
    
			cardValue = value;      //set the cardValye to the value parameter that was passed
			cardColor = "color";   //set cardColor to teh color parameter that was passed
			cardSuit = "suit";    // set cardSuit to the color parameter 
			cardShape = "circle";   //cardShape will always be "circle"
			faceUp = true;       //faceUp will always be true
			}
		
		
		
		
		//default constructor - takes no arguments and assigns default values to the data member.
		
	}


