package com.techelevator;

public abstract class Wall {

public Wall(String name, String color) {
	this.color = color;
	this.name  = name;
}
private String color;
private String name;

public String getColor() {
	return color;
}
public String getName() {
	return name;
}

public String toString() {
	return "Wall [color=" + color + ", name=" + name;

}
	
public abstract int getArea();

}
