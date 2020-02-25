package fr.abm.firstproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileMain {
	
	
	public static void main(String[] args) {
		logWrite();
		logRead();
	}

	private static void logWrite() {
		try {
			Files.write(Paths.get("project.log"), "Ceci est une ligne de tracage \n".getBytes(), 
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Problème lors de l'accès du fichier de log.");
		}
	}
	
	private static void logRead() {
		try {
			List<String> listLines = Files.readAllLines(Paths.get("project.log"));
			for (String line : listLines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Problème lors de l'accès du fichier de log :" + e.getMessage());
		}
	}

}
