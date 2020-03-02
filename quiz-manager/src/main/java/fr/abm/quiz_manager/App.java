package fr.abm.quiz_manager;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.abm.quiz_manager.dataservice.AnswerDAO;
import fr.abm.quiz_manager.dataservice.ChoiceDAO;
import fr.abm.quiz_manager.dataservice.PersonDAO;
import fr.abm.quiz_manager.dataservice.QuestionDAO;
import fr.abm.quiz_manager.dataservice.QuizDAO;
import fr.abm.quiz_manager.entity.Answer;
import fr.abm.quiz_manager.entity.Choice;
import fr.abm.quiz_manager.entity.Person;
import fr.abm.quiz_manager.entity.Question;
import fr.abm.quiz_manager.entity.Quiz;
import fr.abm.quiz_manager.utils.Configuration;


public class App 
{
	
    public static void main( String[] args )
    {
    	System.out.println("Bienvenue dans l'application de gestion de quiz.");
    	boolean admin = login();
    	if (admin) {
    		menuAdmin(); // CRUD sur les quiz, question et choice
    	} else {
    		menuQuiz(); // passer les quiz créés, sauvegarder les réponses en base
    	}
    	
    }
    
    
    
    private static void menuQuiz() {
		Person person = logPerson();
		System.out.println("Quel quiz souhaitez-vous faire ?");
		QuizDAO quizDAO = new QuizDAO();
		QuestionDAO questionDAO = new QuestionDAO();
		ChoiceDAO choiceDAO = new ChoiceDAO();
		AnswerDAO answerDAO = new AnswerDAO();
		List<Quiz> listQuiz = quizDAO.readAllQuizes();
		for(Quiz quiz : listQuiz) {
			System.out.println(quiz.getId() + ". " + quiz.getTitle());
		}
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		Quiz chosenQuiz = listQuiz.stream().filter(q -> q.getId() == choice).collect(Collectors.toList()).get(0);
		List<Question> listQuestions = questionDAO.getQuestionsFromQuiz(chosenQuiz);
		for (Question q : listQuestions) {
			System.out.println(q.getName());
			List<Choice> listChoices = choiceDAO.getChoicesFromQuestion(q);
			for (Choice c : listChoices) {
				System.out.println(listChoices.indexOf(c)+1 + ". " + c.getName());
			}
			int chosenAnswer = scanInt.nextInt();
			Choice chosenChoice = listChoices.get(chosenAnswer-1);
			Answer answer = new Answer(person, chosenChoice, LocalDate.now());
			answerDAO.create(answer);
			if (chosenChoice.isCorrect()) {
				System.out.println("Bonne réponse !");
			} else {
				System.out.println("Mauvaise réponse.");
			}
		}

	}



	private static Person logPerson() {
		System.out.println("Veuillez entrer votre nom :");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Veuillez entrer votre prénom :");
		String surname = scan.nextLine();
		Person person = new Person(name, surname);
		PersonDAO personDAO = new PersonDAO();
		personDAO.create(person);
		return personDAO.getByNameAndSurname(name, surname);
	}



	private static void menuAdmin() {
		System.out.println("Bienvenue dans le menu de gestion "
				+ "; sélectionnez l'objet que vous souhaitez gérer :");
		System.out.println("");
	}



	private static boolean login()  {
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre username :");
		String username = scan.nextLine();
		System.out.println("Veuillez entrer votre mot de passe :");
		String password = scan.nextLine();
		Configuration config = Configuration.getInstance();
		if (config.getPropertyValue("admin_username").equals(username) && config.getPropertyValue("admin_password").equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
