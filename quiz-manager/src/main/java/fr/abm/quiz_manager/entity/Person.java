package fr.abm.quiz_manager.entity;

public class Person {
	
	private int id;
	
	private String name;
	
	private String surname;

	
	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public Person(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	
}
