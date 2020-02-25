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
		System.out.println("Le triangle cr�� a un p�rim�tre de " 
				+ triangle.getPerimeter() + " et une aire de " + triangle.getArea());
		System.out.println("Le cercle cr�� a un p�rim�tre de " 
				+ circle.getPerimeter() + " et une aire de " + circle.getArea());
		System.out.println("Le carr� cr�� a un p�rim�tre de " 
				+ square.getPerimeter() + " et une aire de " + square.getArea());
		
		System.out.println(triangle);

		GeoUtils.parseDate("");
		GeoUtils geo = new GeoUtils();
		geo.generateDate();
		
	}
	

}
