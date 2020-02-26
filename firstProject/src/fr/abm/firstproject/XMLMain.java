package fr.abm.firstproject;

import fr.abm.firstproject.dataservice.AddressXMLDAO;
import fr.abm.firstproject.entity.Address;

public class XMLMain {

	
	public static void main(String[] args) {
		AddressXMLDAO xmlDAO = new AddressXMLDAO();
		Address address = new Address(42, "rue de la republique", "0645789651", "test.test@test.fr");

		xmlDAO.delete(address);
	}
	
}
