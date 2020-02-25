package fr.abm.geometry;

import java.text.ParseException;

import fr.abm.geometry.entity.Circle;
import fr.abm.geometry.entity.Square;
import fr.abm.geometry.entity.Triangle;
import fr.abm.geometry.utils.GeoUtils;

public class GeometryMain {

	public static void main(String[] args) throws ParseException {
		Triangle triangle = new Triangle(5, 7, 8, 10);
		Circle circle = new Circle(4);
		Square square = new Square(6.2);
		System.out.println("Le triangle créé a un périmètre de " 
				+ triangle.getPerimeter() + " et une aire de " + triangle.getArea());
		System.out.println("Le cercle créé a un périmètre de " 
				+ circle.getPerimeter() + " et une aire de " + circle.getArea());
		System.out.println("Le carré créé a un périmètre de " 
				+ square.getPerimeter() + " et une aire de " + square.getArea());
		
		System.out.println(triangle);

		GeoUtils.parseDate("");
		GeoUtils geo = new GeoUtils();
		geo.generateDate();
		
	}
	

}
