package fr.abm.firstproject;


import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMain {
	
	
	private static final String CORRECT_USERNAME = "admin";
	private static final String CORRECT_PASSWORD = "admin";




	public static void main(String[] args) {
		try {
			login();
			menuNavigation();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




	private static void menuNavigation() {
		try (Scanner scan = new Scanner(System.in)){ // try with resources
			boolean menuNavigation = true;
			while (menuNavigation) {
				System.out.println("Veuillez choisir entre : 1. Création   2. Modification   3. Suppression");
				
				int choix = scan.nextInt();
				switch(choix) {
					case 1: 	System.out.println("Bienvenue dans le menu de création");
								break;
					case 2: 	System.out.println("Bienvenue dans le menu de modification");
								break;
					case 3: 	System.out.println("Bienvenue dans le menu de suppression");
								break;
					default:	System.out.println("Choix invalide"); 
				}
				System.out.println("Voulez-vous revenir au menu principal ou bien quitter l'application ?");
				System.out.println("1. Menu principal    2. Quitter l'application");
				choix = scan.nextInt();
				if (choix != 1) {
					menuNavigation = false;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Mauvais type de réponse");
		}
		
	}




	private static void login() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre username :");
		String username = scan.nextLine();
		System.out.println("Veuillez entrer votre mot de passe :");
		String password = scan.nextLine();
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
