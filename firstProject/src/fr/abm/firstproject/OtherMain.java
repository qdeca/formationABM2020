package fr.abm.firstproject;

import java.math.BigDecimal;

public class OtherMain {

	// d�finition de constante
	// static rend cette constante ind�pendante de l'instance de l'objet OtherMain
	// final emp�che cette constante d'�tre red�finie
	private static final String DEUX = "2";
	

	public static void main(String[] args) {
		stringManipulation();
		
		bigDecimalManipulation();
	}

	private static void bigDecimalManipulation() {
		BigDecimal test = new BigDecimal(5);
		BigDecimal test2 = new BigDecimal(5);
		if (test.equals(test2)) {
			System.out.println("�galit� de test et test2");
		} else {
			System.out.println("test et test2 ne sont pas �gaux");
		}
		boolean isEqual = test.equals(test2) ? true : false;
		if (isEqual) System.out.println("�galit� de test et test2");
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
			System.out.println(v + " et " + n + " sont �gaux");
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
