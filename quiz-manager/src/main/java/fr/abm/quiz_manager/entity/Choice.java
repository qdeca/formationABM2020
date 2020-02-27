package fr.abm.quiz_manager.entity;

public class Choice {
	
	private int id;
	
	private String name;
	
	private Question question;
	
	private boolean correct;

	
	public Choice(String name, Question question, boolean correct) {
		super();
		this.name = name;
		this.question = question;
		this.correct = correct;
	}

	public Choice(int id, String name, Question question, boolean correct) {
		super();
		this.id = id;
		this.name = name;
		this.question = question;
		this.correct = correct;
	}

	public int getId() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
