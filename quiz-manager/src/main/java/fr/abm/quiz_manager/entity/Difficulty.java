package fr.abm.quiz_manager.entity;

public enum Difficulty {
	EASY (1),
	NORMAL (3),
	HARD (5);

	private int value;
	
	private Difficulty(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
