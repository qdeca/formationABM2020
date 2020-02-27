package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.abm.quiz_manager.entity.Question;

public class QuestionDAO extends AbstractDAO<Question> {

	@Override
	public void create(Question question) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO QUESTION(NAME, DIFFICULTY, QUIZ_ID) VALUES(?, ?, ?)");
			statement.setString(1, question.getName());
			statement.setString(2, question.getDifficulty().toString());
			statement.setInt(3, question.getQuiz().getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Question question) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement("UPDATE QUESTION SET NAME=?, DIFFICULTY=?, QUIZ_ID=? WHERE ID=?");
			statement.setString(1, question.getName());
			statement.setString(2, question.getDifficulty().toString());
			statement.setInt(3, question.getQuiz().getId());
			statement.setInt(4, question.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Question question) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM QUESTION WHERE ID=?");
			statement.setInt(1, question.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
