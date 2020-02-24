package fr.abm.firstproject;

public enum Saison {

	PRINTEMPS (1, ""),
	ETE (2),
	AUTOMNE (3, ""),
	HIVER (4, "");
	
	public int ordre;
	
	Saison(int ordre, String toto) {
		this.ordre = ordre;
	}
	Saison(int ordre) {
		this.ordre = ordre;
	}
}
