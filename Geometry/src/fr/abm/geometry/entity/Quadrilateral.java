package fr.abm.geometry.entity;

public abstract class Quadrilateral  implements Shape{
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public final double sumAreaAndPerimeter() {
		return getArea() + getPerimeter();
	}

}
