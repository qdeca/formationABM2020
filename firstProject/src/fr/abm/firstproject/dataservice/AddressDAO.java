package fr.abm.firstproject.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.abm.firstproject.entity.Address;

public class AddressDAO {

	public boolean create(Address address) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:C:/Formation2020/ABM/db/h2DS", "sa", "");
			PreparedStatement statement = conn.prepareStatement("INSERT INTO ADDRESS VALUES(?, ?, ?, ?)");
			statement.setString(1, address.getMail());
			statement.setInt(2, address.getStreetNumber());
			statement.setString(3, address.getStreetName());
			statement.setString(4, address.getPhoneNumber());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
