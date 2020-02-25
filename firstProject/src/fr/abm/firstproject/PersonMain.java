package fr.abm.firstproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fr.abm.firstproject.entity.Person;
import fr.abm.firstproject.utils.DateUtils;

public class PersonMain {

	public static void main(String[] args) {
		Person firstPerson = new Person("Dupont", "Jean", 42);
		Person secondPerson = new Person("Dubois", "Jean", 40);
		Person thirdPerson = new Person();
		thirdPerson.setName("Durand");
		thirdPerson.setSurname("Jean");
		thirdPerson.setAge(38);
		Person fourthPerson = new Person("Bichon", "Georges", 40);
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);
//		secondPerson.mood = "sad";
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);
		mapSaisons();
		//personMap(firstPerson, secondPerson, thirdPerson, fourthPerson);
		

		LocalDate today = LocalDate.now();
		LocalDate firstOfMonth = DateUtils.getFirstDayOfMonth(today);
		System.out.println(firstOfMonth);
	}

	private static void personList(Person firstPerson, Person secondPerson, Person thirdPerson) {
		List<Person> listPerson; // déclaration de la liste (interface)
		listPerson = new ArrayList<>(); // instanciation de l'ArrayList (classe)
		listPerson.add(firstPerson);
		listPerson.add(secondPerson);
		listPerson.add(thirdPerson);
		Collections.sort(listPerson);
		
		for (Person person : listPerson) {
			System.out.println(person.getName());
		}
	}
	
	private static void personSet(Person firstPerson, Person secondPerson, Person thirdPerson) {
		Set<Person> setPerson; // déclaration du set (interface)
		setPerson = new HashSet<>(); // instanciation du HashSet (classe)
		setPerson.add(firstPerson);
		setPerson.add(secondPerson);
		setPerson.add(thirdPerson);
		setPerson.add(firstPerson);
		
		for (Person person : setPerson) {
			System.out.println(person.getName());
		}
	}
	
	private static void personMap(Person firstPerson, Person secondPerson, Person thirdPerson, Person fourthPerson) {
		Map<Integer, List<Person>> mapAgePersons; // déclaration de la map qui donne toutes les personnes
												  // associées à un âge donné 
												  // (âge = key, liste personne = value)
		mapAgePersons = new HashMap<>(); // instanciation de la HashMap (classe)
		insertPerson(mapAgePersons, firstPerson);
		insertPerson(mapAgePersons, secondPerson);
		insertPerson(mapAgePersons, thirdPerson);
		insertPerson(mapAgePersons, fourthPerson);
		
		
		for (Entry<Integer, List<Person>> entry : mapAgePersons.entrySet()) { // moyen de parcourir 
													// une map en ayant accès à chaque association
													// clé-valeur
			
			String print = "Il existe " + entry.getValue().size() + " personnes ayant l'âge suivant : "
				+ entry.getKey() + " : ";
			for (Person p : entry.getValue()) { 
				print += p.getName() + ", ";
			}
			System.out.println(print);
		}
	}

	/**
	 * Insère dans la map spécifiée une personne 
	 * @param mapAgePersons relie toutes les personnes d'un âge donné
	 * @param firstPerson personne à ajouter à la map existante
	 */
	private static void insertPerson(Map<Integer, List<Person>> mapAgePersons, Person firstPerson) {
		List<Person> listPersons = mapAgePersons.get(firstPerson.getAge()); 
									// on récupère la liste de personnes associées à un âge donné
		if (listPersons == null) { // si la map ne contient aucune personne de cet âge encore
			listPersons = new ArrayList<>();	// on créé la liste
		}
		listPersons.add(firstPerson);			// on ajoute la personne à la liste
		mapAgePersons.put(firstPerson.getAge(), listPersons);   // on met à jour la liste dans la map
		
	}
	
	
	private static void mapSaisons() {
		Map<String, Integer> mapSaisons = new HashMap<String, Integer>();
		mapSaisons.put("Printemps", 1);
		mapSaisons.put("Eté", 2);
		mapSaisons.put("Automne", 3);
		mapSaisons.put("Hiver", 4);
		for (Entry<String, Integer> entry : mapSaisons.entrySet()) {
			System.out.println(entry.getKey() + " est la saison n° " + entry.getValue());
		}
	}
}
