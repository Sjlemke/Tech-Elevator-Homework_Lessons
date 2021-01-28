package com.techelevator;

public class RectangleWall extends Wall {

public RectangleWall(String name, String color, int length, int height) {
	super(name, color);
    this.length = length;
    this.height = height;
}

public int length;
public int height;

public String toString() {
	return getName() + " (" + Integer.toString(length) + "x" + Integer.toString(height) + ") rectangle"; }

public int getHeight() {
return height; }

public int getLength() {
	return length;
}
public int getArea() {
	return height * length;
}

}
