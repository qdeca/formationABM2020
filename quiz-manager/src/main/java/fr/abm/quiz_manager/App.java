package fr.abm.quiz_manager;

import java.util.Scanner;

import fr.abm.quiz_manager.utils.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Bienvenue dans l'application de gestion de quiz.");
    	boolean admin = login();
    	if (admin) {
    		menuAdmin(); // CRUD sur les quiz, question et choice
    	} else {
    		menuQuiz(); // passer les quiz créés
    	}
    	
    }
    
    
    
    private static void menuQuiz() {
		
	}



	private static void menuAdmin() {
		System.out.println("Bienvenue dans le menu de gestion "
				+ "; sélectionnez l'objet que vous souhaitez gérer :");
		System.out.println("");
	}



	private static boolean login()  {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre username :");
		String username = scan.nextLine();
		System.out.println("Veuillez entrer votre mot de passe :");
		String password = scan.nextLine();
		Configuration config = Configuration.getInstance();
		if (config.getPropertyValue("admin_username").equals(username) && config.getPropertyValue("admin_password").equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
