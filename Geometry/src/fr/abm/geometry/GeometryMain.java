package fr.abm.geometry;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.abm.geometry.entity.Circle;
import fr.abm.geometry.entity.Shape;
import fr.abm.geometry.entity.Square;
import fr.abm.geometry.entity.Triangle;

public class GeometryMain {

	public static void main(String[] args) throws ParseException {
		Triangle triangle = new Triangle(5, 7, 8, 10);
		Circle circle = new Circle(4);
		Square square = new Square(6.2);

		List<Shape> listShapes = Arrays.asList(triangle, circle, square);
		
		for (Shape shape : listShapes) {
			String[] types = shape.getClass().getName().split("\\.");
			System.out.println("Le " + types[types.length-1]+ " créé a un périmètre de " + shape.getPerimeter());
			System.out.println("Le " + types[types.length-1] + " créé a une aire de " + shape.getArea());
		}

		
	}
	

}
