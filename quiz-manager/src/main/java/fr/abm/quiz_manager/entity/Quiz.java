package fr.abm.quiz_manager.entity;

public class Quiz {

	private int id;
	
	private String title;
	
	private Topic topic;
	
	

	public Quiz(String title, Topic topic) {
		super();
		this.title = title;
		this.topic = topic;
	}

	public Quiz(int id, String title, Topic topic) {
		super();
		this.id = id;
		this.title = title;
		this.topic = topic;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
	
}
