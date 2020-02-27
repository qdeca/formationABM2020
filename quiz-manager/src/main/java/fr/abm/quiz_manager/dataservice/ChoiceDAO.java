package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.abm.quiz_manager.entity.Choice;

public class ChoiceDAO extends AbstractDAO<Choice> {

	@Override
	public void create(Choice choice) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO CHOICE(NAME, CORRECT, QUESTION_ID) VALUES(?, ?, ?)");
			statement.setString(1, choice.getName());
			statement.setBoolean(2, choice.isCorrect());
			statement.setInt(3, choice.getQuestion().getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Choice choice) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement("UPDATE CHOICE SET NAME=?, CORRECT=?, QUESTION_ID=? WHERE ID=?");
			statement.setString(1, choice.getName());
			statement.setBoolean(2, choice.isCorrect());
			statement.setInt(3, choice.getQuestion().getId());
			statement.setInt(4, choice.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Choice choice) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM CHOICE WHERE ID=?");
			statement.setInt(1, choice.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
