package fr.abm.quiz_manager.entity;

import java.time.LocalDate;

public class Answer {
	
	private int id;
	
	private Person person;
	
	private Choice choice;
	
	private LocalDate date;

	
	public Answer(Person person, Choice choice, LocalDate date) {
		super();
		this.person = person;
		this.choice = choice;
		this.date = date;
	}


	public Answer(int id, Person person, Choice choice, LocalDate date) {
		super();
		this.id = id;
		this.person = person;
		this.choice = choice;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
