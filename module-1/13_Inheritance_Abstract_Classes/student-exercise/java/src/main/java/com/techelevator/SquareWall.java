package com.techelevator;

public class SquareWall extends RectangleWall {
	public SquareWall(String name, String color, int sideLength) {
	super(name, color, sideLength, sideLength);
	this.sideLength = sideLength;
}

	public String color;
	public String name;
    public int sideLength;

public String toString() {
   return getName() + " (" + Integer.toString(sideLength) + "x" + Integer.toString(sideLength) + ") square"; }
  
public int getSideLength() {
	return sideLength;
}

public int getArea() {
	return sideLength * sideLength;
}
}
