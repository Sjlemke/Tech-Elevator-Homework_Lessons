package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/****************************************************************************************************
 * American Playing Card Class - subclass of generic PlayingCard
 ***************************************************************************************************/

public class AmericanPlayingCard extends PlayingCard{ //extends means this is subclass of playingcard
	/************************************************************************************************
	 * Constants for values related to American Playing Cards
	 * 
	 * since constants cannot be changed (final) we make them:
	 * 
	 * static - only one occurance of the variable regardless of the number of object defined.
	 * final - cannot be changed once they are assigned a value
	 ***********************************************************************************************/	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	/**************************************************************************************************
	 * Maps used to validate/limit suits, colors and value names for American Playing Cards
	 * 
	 * use static to have only one occurance of the variable shared by all objects
	 * since the contents of these Maps will be same for all AmericanPlayingCards,
	 * we dont need more than one of each 
	 *************************************************************************************************/	
	
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	/***************************************************************************************************
	 *Invoke method to populate maps with valid suits, colors & value names for American Playing Cards
	 **************************************************************************************************/	
	
	static {             // static method to initialize maps before are ever used
       initializeMaps();
    }
	/***************************************************************************************************
	 * 0-arg / Default Constructor
	 **************************************************************************************************/		
	public AmericanPlayingCard() 
	{   //the keyword super references the super class - super() represents a super class ctor.
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);  // Invoke 3-arg ctor in superclass
		                                                     //using the default values for this class.
	} 
	/***************************************************************************************************
	 * 2-arg Constructor for a user provided value and suit
	 ***************************************************************************************************/	
	public AmericanPlayingCard(int value, String suit) {
		super(value, suit, suitMap.get(suit));       // Determine color and call super class 3-arg ctor
	
		if (value > MAXVALUE) {                      // If value provided is greater than max value allowed         
			setValue(MAXVALUE);                      //      set it to max value allowed
		}
		if (value < MINVALUE) {                      // If value provided is greater than min value allowed  
			setValue(MINVALUE);                      //      set it to min value allowed
		}
	}
	/****************************************************************************************************
	 * Initialize Maps to valid suit/color combinations and value names
	 * 
	 * set up the Maps with the suit/color and the value name associations. 
	 ***************************************************************************************************/	
	private static void initializeMaps() {
		suitMap.put("SPADES"  , "BLACK");
		suitMap.put("CLUBS"   , "BLACK");
		suitMap.put("DIAMONDS", "RED");
		suitMap.put("HEARTS"  , "RED");
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}

	

}
