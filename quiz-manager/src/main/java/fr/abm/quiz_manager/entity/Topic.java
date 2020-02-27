package fr.abm.quiz_manager.entity;

public class Topic {
	
	private int id;
	
	private String name;


	public Topic(String name) {
		super();
		this.name = name;
	}


	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
