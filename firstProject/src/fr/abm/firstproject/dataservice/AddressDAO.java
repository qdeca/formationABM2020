package fr.abm.firstproject.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.abm.firstproject.entity.Address;

public class AddressDAO {

	public static boolean create(Address address) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:C:/Formation2020/ABM/db/h2DS", "sa", "");
			PreparedStatement statement = conn.prepareStatement("INSERT INTO ADDRESS VALUES(?, ?, ?, ?)");
			statement.setString(1, address.getMail());
			statement.setInt(2, address.getStreetNumber());
			statement.setString(3, address.getStreetName());
			statement.setString(4, address.getPhoneNumber());
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Address> readAllAddresses() {
		List<Address> listAddress = new ArrayList<Address>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:C:/Formation2020/ABM/db/h2DS", "sa", "");
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM ADDRESS");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String mail = resultSet.getString(1);
				int streetNumber = resultSet.getInt(2);
				String streetName = resultSet.getString(3);
				String phoneNumber = resultSet.getString(4);
				Address address = new Address(streetNumber, streetName, phoneNumber, mail);
				listAddress.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAddress;
	}
	
	
	public static boolean update(Address address) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:C:/Formation2020/ABM/db/h2DS", "sa", "");
			PreparedStatement statement = conn.prepareStatement("UPDATE ADDRESS SET STREETNUMBER=?, STREETNAME=?, PHONENUMBER=? WHERE MAIL=?");
			statement.setInt(1, address.getStreetNumber());
			statement.setString(2, address.getStreetName());
			statement.setString(3, address.getPhoneNumber());
			statement.setString(4, address.getMail());
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(Address address) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:C:/Formation2020/ABM/db/h2DS", "sa", "");
			PreparedStatement statement = conn.prepareStatement("DELETE FROM ADDRESS WHERE MAIL=?");
			statement.setString(1, address.getMail());
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
