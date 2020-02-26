package fr.abm.firstproject;

import fr.abm.firstproject.dataservice.AddressDAO;
import fr.abm.firstproject.entity.Address;

public class DAOMain {
	
	
	public static void main(String[] args) {
		Address address = new Address(42, "rue de la republique", "0645789651", "test.test@test.fr");
		AddressDAO.create(address);
	}

}
