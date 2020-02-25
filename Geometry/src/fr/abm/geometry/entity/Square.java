package fr.abm.geometry.entity;

public class Square extends Rectangle  implements Shape{
	
	public Square(double side) {
		super(side, side);
	}
	
	public double getSide() {
		return this.getLength();
		// return this.width;
	}

	//polymorphisme
	@Override
	public double getArea() {
		return super.getArea();
	}

	
	public void setSide(double side) {
		this.setLength(side);
		this.setWidth(side);
		this.getArea();
	}
	
	

}
