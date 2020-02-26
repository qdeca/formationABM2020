package fr.abm.firstproject.dataservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import fr.abm.firstproject.entity.Address;

public class AddressFileDAO {
	
	public static final String ADDRESS_FILE = "address.data";
	
	public boolean create(Address address) {
		try {
			String stringAddress = address.toString() + "\n";
			Files.write(Paths.get(ADDRESS_FILE), stringAddress.getBytes(), 
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Erreur lors de la création de l'adresse");
			return false;
		}
		return true;
		
	}
	
	public List<Address> readAllLines() {
		List<Address> listAddress = new ArrayList<Address>();
		try {
 			List<String> listStringAddress = Files.readAllLines(Paths.get(ADDRESS_FILE));
 			for (String stringAddress : listStringAddress) {
 				String[] parsedString = stringAddress.split(";;");
 				Address address = new Address(Integer.valueOf(parsedString[0]), parsedString[1], parsedString[2], parsedString[3]);
 				listAddress.add(address);
 			}
			
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture du fichier");
		}
		return listAddress;
	}

	public boolean update(Address address) {
		List<Address> listAddress = readAllLines();
		for (Address a : listAddress) {
			if (a.equals(address)) {
				a = address;
			}
		}
		return true;
	}
	
	public boolean delete(Address address) {
		List<Address> listAddress = readAllLines();
		String stringAddress = "";
		for (Address a : listAddress) {
			if (a.equals(address)) {
				listAddress.remove(a);
			} else {
				stringAddress += a.toString();
				stringAddress += "\n";
			}
			
		}


		try {
			Files.write(Paths.get(ADDRESS_FILE), stringAddress.getBytes());
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
