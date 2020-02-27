package fr.abm.quiz_manager.entity;

public class Question {
	
	private int id;
	
	private String name;
	
	private Quiz quiz;
	
	private Difficulty difficulty;

	public Question(String name, Quiz quiz, Difficulty difficulty) {
		super();
		this.name = name;
		this.quiz = quiz;
		this.difficulty = difficulty;
	}

	public Question(int id, String name, Quiz quiz, Difficulty difficulty) {
		super();
		this.id = id;
		this.name = name;
		this.quiz = quiz;
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	
	

}
