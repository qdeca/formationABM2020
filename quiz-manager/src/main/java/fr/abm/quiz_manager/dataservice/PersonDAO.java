package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.abm.quiz_manager.entity.Person;
import fr.abm.quiz_manager.entity.Quiz;
import fr.abm.quiz_manager.entity.Topic;

public class PersonDAO extends AbstractDAO<Person> {

	@Override
	public void create(Person person) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO PERSON(NAME, SURNAME) VALUES(?, ?)");
			statement.setString(1, person.getName());
			statement.setString(2, person.getSurname());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Person person) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("UPDATE PERSON SET NAME=?, SURNAME=? WHERE ID=?");
			statement.setString(1, person.getName());
			statement.setString(2, person.getSurname());
			statement.setInt(3, person.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person person) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM PERSON WHERE ID=?");
			statement.setInt(1, person.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Person getByNameAndSurname(String name, String surname) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERSON WHERE NAME=? AND SURNAME=?");
			statement.setString(1, name);
			statement.setString(2, surname);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt(1);
			Person person = new Person(id, name, surname);

		
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
