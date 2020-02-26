package fr.abm.geometry.service;

import java.util.List;

import fr.abm.geometry.entity.Shape;
import fr.abm.geometry.entity.Square;

public class CalculFormes<T extends Shape> {
	
	private T shape;
	
	public CalculFormes(T shape) {
		this.shape = shape;
	}
	
	public String getTypeClass(List<? super Square> list) {
		return this.shape.getClass().getName();
	}
	
	public double computeAreaAndPerimeter() {
		return this.shape.getArea() + this.shape.getPerimeter();
	}

}
