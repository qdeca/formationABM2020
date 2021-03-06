package fr.abm.geometry.entity;

public class Rectangle implements Shape{
	
	private double length;
	
	private double width;
	
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public final double getPerimeter() {
		return this.length *2 + this.width*2;
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	
	

}
