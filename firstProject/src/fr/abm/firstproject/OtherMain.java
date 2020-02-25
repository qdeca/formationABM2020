package fr.abm.firstproject;

import java.math.BigDecimal;

public class OtherMain {

	// définition de constante
	// static rend cette constante indépendante de l'instance de l'objet OtherMain
	// final empêche cette constante d'être redéfinie
	private static final String DEUX = "2";
	

	public static void main(String[] args) {
		stringManipulation();
		
		bigDecimalManipulation();
	}

	private static void bigDecimalManipulation() {
		BigDecimal test = new BigDecimal(5);
		BigDecimal test2 = new BigDecimal(5);
		if (test.equals(test2)) {
			System.out.println("égalité de test et test2");
		} else {
			System.out.println("test et test2 ne sont pas égaux");
		}
		boolean isEqual = test.equals(test2) ? true : false;
		if (isEqual) System.out.println("égalité de test et test2");
	}

	private static void stringManipulation() {
		String deux = DEUX;
		String v = "test";
		String n = returnNull();
		
		Saison saison = Saison.AUTOMNE;
		System.out.println(saison.ordre);


		System.out.print("Longueur de '" + deux + "' : " + deux.length() + "\n");
		System.out.println("\tLongueur de '" + v + "' : " + v.length());
		System.out.println("\tLongueur de '" + n + "' : " + n.length());

		if (n.equals(v)) {
			System.out.println(v + " et " + n + " sont égaux");
		}
		String replace = "Ceci est un test mais Ceci est bien";
		replace = replace.replaceAll("Ceci", "Cela");
		System.out.println(replace);
		
		switch (v) {
		case "test" : System.out.println("la valeur est test");
						break;
		default : System.out.println("autre valeur");
		}
	}

	public static String returnNull() {
		return "test";
	}
}
