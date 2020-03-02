package fr.natsystem.quiz_manager;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

import fr.abm.quiz_manager.dataservice.ChoiceDAO;
import fr.abm.quiz_manager.dataservice.QuestionDAO;
import fr.abm.quiz_manager.dataservice.QuizDAO;
import fr.abm.quiz_manager.entity.Choice;
import fr.abm.quiz_manager.entity.Difficulty;
import fr.abm.quiz_manager.entity.Question;
import fr.abm.quiz_manager.entity.Quiz;

public class AppTest {


	QuizDAO quizDAO = new QuizDAO();
	QuestionDAO questionDAO = new QuestionDAO();
	ChoiceDAO choiceDAO = new ChoiceDAO();
	
	
	public double computation(double a, double b, BiFunction<Double, Double, Double> f) {
		return f.apply(a, b);
	}
	
	public double computation(double a, Function<Double, Double> f) {
		return f.apply(a);
	}
	
	@Test
    public void testApp()
    {
        System.out.println(computation(5, 2, Math::pow));
        System.out.println(computation(4, 3, Math::hypot));
        System.out.println(computation(4.5, Math::floor));
       
    }
	
	@Test
	public void dataCreation() {
		Quiz quiz = quizDAO.getById(2);
		Question question = questionDAO.readAllQuestions().get(0);
		Choice firstChoice = new Choice("Paris", question, true);
		Choice secondChoice = new Choice("Lyon", question, false);
		Choice thirdChoice = new Choice("Perpignan", question, false);
		
		Question otherQuestion = questionDAO.readAllQuestions().get(1);
		Choice fourthChoice = new Choice("Saint-Petersburg", otherQuestion, false);
		Choice fifthChoice = new Choice("Kiev", otherQuestion, false);
		Choice sixthChoice = new Choice("Moscou", otherQuestion, true);
		//questionDAO.create(otherQuestion);
		List<Choice> listChoices = Arrays.asList(fourthChoice, fifthChoice, sixthChoice);
		listChoices.forEach(c -> choiceDAO.create(c));
		
		
	}
	
	
}
