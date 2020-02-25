package fr.abm.firstproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMain {
	
	
	private static final String CORRECT_USERNAME = "admin";
	private static final String CORRECT_PASSWORD = "admin";




	public static void main(String[] args) {
		try {
			login();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




	private static void login() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre username :");
		String username = scan.nextLine();
		System.out.println("Veuillez entrer votre mot de passe :");
		String password = scan.nextLine();
		scan.close();
		if (CORRECT_USERNAME.equals(username) && CORRECT_PASSWORD.equals(password)) {
			System.out.println("Bienvenue !");
		} else {
			throw new Exception("Problème dans le login");
		}
	}
	
	
	
	
	private static void saisieAge() throws InputMismatchException {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Veuillez entrer votre age :");
		int age = scan2.nextInt();
		System.out.println("Votre age est " + age);
		scan2.close();
	}

}
