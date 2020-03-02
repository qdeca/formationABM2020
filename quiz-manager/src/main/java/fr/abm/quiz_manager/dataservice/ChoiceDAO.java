package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.abm.quiz_manager.entity.Choice;
import fr.abm.quiz_manager.entity.Difficulty;
import fr.abm.quiz_manager.entity.Question;
import fr.abm.quiz_manager.entity.Quiz;

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
	
	public List<Choice> getChoicesFromQuestion(Question	question) {
		List<Choice> listChoices = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM CHOICE WHERE QUESTION_ID = ?");
			statement.setInt(1, question.getId());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name	= resultSet.getString(2);
				boolean correct = resultSet.getBoolean(3);
				Choice choice = new Choice(id, name, question, correct);
				listChoices.add(choice);
			}
			return listChoices;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
