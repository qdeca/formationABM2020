package fr.abm.firstproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre username :");
		String username = scan.nextLine();
		System.out.println("Votre username est " + username);
		
		try {
			System.out.println("Veuillez entrer votre age :");
			int age = scan.nextInt();
			System.out.println("Votre age est " + age);
		} catch (InputMismatchException e) {
			System.out.println("Saisie Incorrecte");
		}

		
		
		scan.close();
	}

}
