package fr.natsystem.quiz_manager.dataservice;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import fr.abm.quiz_manager.dataservice.QuizDAO;
import fr.abm.quiz_manager.dataservice.TopicDAO;
import fr.abm.quiz_manager.entity.Quiz;
import fr.abm.quiz_manager.entity.Topic;

public class QuizDaoTest {
	
	private QuizDAO quizDAO = new QuizDAO();

	private TopicDAO topicDAO = new TopicDAO();

	@Test
	public void quizTest() {
		topicDAO.create(new Topic("Java"));
		Topic topic = topicDAO.getTopicByName("Java");
		Quiz quiz = new Quiz("Premier quiz java", topic);
		quizDAO.create(quiz);
		Quiz quizFromDB = quizDAO.readAllQuizes().get(0);
		Assert.assertNotNull(quizFromDB);
		quizDAO.delete(quizFromDB);
		
		List<Quiz> listQuiz = quizDAO.readAllQuizes();
		listQuiz.stream()
			.filter(q -> q.getTopic().getName().equals("Java"))
			.collect(Collectors.toList());

		listQuiz.stream().forEach(q -> System.out.println(q.getTitle()));
	}
	
	

}
