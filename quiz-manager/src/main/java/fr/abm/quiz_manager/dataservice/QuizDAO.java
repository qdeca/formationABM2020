package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.abm.quiz_manager.entity.Quiz;
import fr.abm.quiz_manager.entity.Topic;

public class QuizDAO extends AbstractDAO<Quiz> {
	
	
	public void create(Quiz quiz) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO QUIZ(TITLE, TOPIC_ID) VALUES(?, ?)");
			statement.setString(1, quiz.getTitle());
			statement.setInt(2, quiz.getTopic().getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Quiz> readAllQuizes() {
		List<Quiz> listQuizes = new ArrayList<Quiz>();
		TopicDAO topicDAO = new TopicDAO();
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM QUIZ");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				int topicId = resultSet.getInt(3);
				Topic topic = topicDAO.getTopicById(topicId);
				Quiz quiz = new Quiz(id, title, topic);
				listQuizes.add(quiz);
			}
			return listQuizes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void update(Quiz quiz) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("UPDATE QUIZ SET TITLE=?, TOPIC_ID=? WHERE ID=?");
			statement.setString(1, quiz.getTitle());
			statement.setInt(2, quiz.getTopic().getId());
			statement.setInt(3, quiz.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void delete(Quiz quiz) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM QUIZ WHERE ID=?");
			statement.setInt(1, quiz.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
