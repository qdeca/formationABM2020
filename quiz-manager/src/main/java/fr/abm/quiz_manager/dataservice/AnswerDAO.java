package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.abm.quiz_manager.entity.Answer;

public class AnswerDAO extends AbstractDAO<Answer> {

	@Override
	public void create(Answer answer) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO ANSWER(PERSON_ID, CHOICE_ID, DATE) VALUES(?, ?, ?)");
			statement.setInt(1, answer.getPerson().getId());
			statement.setInt(2, answer.getChoice().getId());
			statement.setObject(3, answer.getDate());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Answer answer) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement("UPDATE ANSWER SET PERSON_ID=?, CHOICE_ID=?, DATE_ID=? WHERE ID=?");
			statement.setInt(1, answer.getPerson().getId());
			statement.setInt(2, answer.getChoice().getId());
			statement.setObject(3, answer.getDate());
			statement.setInt(4, answer.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Answer answer) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM ANSWER WHERE ID=?");
			statement.setInt(1, answer.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
