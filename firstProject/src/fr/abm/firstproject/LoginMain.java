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
			saisieAge();
		} catch (InputMismatchException e) {
			System.out.println("Mauvaise saisie");
			throw new InputMismatchException();
		} catch (NullPointerException e) {
			System.out.println("null");
		} catch (Exception e) {
			System.out.println("Une exception est survenue");
		} finally {
			System.out.println("Fin du questionnaire");
		}
		scan.close();
	}
	
	
	private static void saisieAge() throws InputMismatchException {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Veuillez entrer votre age :");
		int age = scan2.nextInt();
		System.out.println("Votre age est " + age);
		scan2.close();
	}

}
