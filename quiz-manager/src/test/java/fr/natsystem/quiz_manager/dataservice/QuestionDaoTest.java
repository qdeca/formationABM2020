package fr.natsystem.quiz_manager.dataservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import fr.abm.quiz_manager.dataservice.QuestionDAO;
import fr.abm.quiz_manager.dataservice.QuizDAO;
import fr.abm.quiz_manager.dataservice.TopicDAO;
import fr.abm.quiz_manager.entity.Difficulty;
import fr.abm.quiz_manager.entity.Question;
import fr.abm.quiz_manager.entity.Quiz;
import fr.abm.quiz_manager.entity.Topic;

public class QuestionDaoTest {

	
	TopicDAO topicDAO = new TopicDAO();
	
	QuizDAO quizDAO = new QuizDAO();
	
	QuestionDAO questionDAO = new QuestionDAO();
	
	@Test
	public void questionTest() {
        Map<String, List<Question>> mapQuestionsPerTopic = new HashMap<String, List<Question>>();
        Map<List<Question>, Integer> mapQuestionsPerDifficulty = new HashMap<List<Question>, Integer>();
        List<Question> listQuestions = questionDAO.readAllQuestions();
        if (listQuestions.stream().anyMatch(q -> "Java".equals(q.getQuiz().getTopic().getName()))) {
        	for (Question question : listQuestions) {
        		String topicName = question.getQuiz().getTopic().getName();
        		List<Question> list = mapQuestionsPerTopic.get(topicName);
				if (list == null) {
        			mapQuestionsPerTopic.put(topicName, new ArrayList<>(Arrays.asList(question)));
        		} else {
        			list.add(question);
        			mapQuestionsPerTopic.put(topicName, list);
        		}
        	}
        	mapQuestionsPerTopic.forEach((t, lq) -> {
        		mapQuestionsPerDifficulty.put(lq, lq.stream().mapToInt(q -> q.getDifficulty().getValue()).sum());
        	});
        }
        listQuestions.stream().collect(Collectors.toList());
	}
	
	
	@Test
	public void createQuestion() {
//		topicDAO.create(new Topic("Geographie"));
//		Topic topic = topicDAO.getTopicByName("Geographie");
//		Quiz quiz = new Quiz("Capitales", topic);
//		quizDAO.create(quiz);
		Quiz quiz = quizDAO.getByTitle("Capitales");
		Question question = new Question("Quelle est la capitale de la France ?", quiz, Difficulty.EASY);
		questionDAO.create(question);

	}
	
	
	
	
	
	
	
	
	
	
	
}
