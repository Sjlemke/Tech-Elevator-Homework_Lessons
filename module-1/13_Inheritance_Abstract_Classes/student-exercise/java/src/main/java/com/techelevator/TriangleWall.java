package com.techelevator;

public class TriangleWall extends Wall{
	
	public TriangleWall(String name, String color, int base, int height) {
		super(name, color);
		this.base = base;
		this.height = height;

	}
	public int base;
	public int height;

public String toString() {
    	return getName() + " (" + Integer.toString(base) + "x" + Integer.toString(height) + ") triangle"; }

 public int getBase() {
    	return base; 
 }
 public int getHeight() {
	   return height;
 }
public int getArea() {
	return getBase() * getHeight() /2; 
}
}