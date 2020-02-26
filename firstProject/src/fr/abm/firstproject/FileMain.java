package fr.abm.firstproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import fr.abm.firstproject.dataservice.AddressFileDAO;
import fr.abm.firstproject.entity.Address;

public class FileMain {
	
	
	public static void main(String[] args) {
//		logWrite();
//		logRead();
		//createAddress();
		readAddress();
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
	
	private static void createAddress() {
		AddressFileDAO dao = new AddressFileDAO();
		Address address = new Address(42, "rue de la republique", "0645789651", "test.test@test.fr");
		dao.create(address);
	}

	private static void readAddress() {
		AddressFileDAO dao = new AddressFileDAO();
		List<Address> listAddress = dao.readAllLines();
		for(Address address : listAddress) {
			System.out.println(address);
		}
	}
}
