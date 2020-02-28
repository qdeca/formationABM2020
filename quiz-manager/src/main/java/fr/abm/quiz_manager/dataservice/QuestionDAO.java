package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.abm.quiz_manager.entity.Difficulty;
import fr.abm.quiz_manager.entity.Question;
import fr.abm.quiz_manager.entity.Quiz;

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
	
	public List<Question> readAllQuestions() {
		List<Question> listQuestions = new ArrayList<>();
		QuizDAO quizDAO = new QuizDAO();
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM QUESTIONS");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name	= resultSet.getString(2);
				Difficulty difficulty = Difficulty.valueOf(resultSet.getString(3));
				int quizId = resultSet.getInt(4);
				Quiz quiz = quizDAO.getById(quizId);
				Question question = new Question(id, name, quiz, difficulty);
				listQuestions.add(question);
			}
			return listQuestions;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
