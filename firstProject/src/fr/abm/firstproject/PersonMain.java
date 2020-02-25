package fr.abm.firstproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);
//		secondPerson.mood = "sad";
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);
		
		ArrayList<Person> listPerson = new ArrayList<Person>();
		listPerson.add(firstPerson);
		listPerson.add(secondPerson);
		listPerson.add(thirdPerson);
		Collections.sort(listPerson);
		
		for (Person person : listPerson) {
			System.out.println(person.getName());
		}
		

		LocalDate today = LocalDate.now();
		LocalDate firstOfMonth = DateUtils.getFirstDayOfMonth(today);
		System.out.println(firstOfMonth);
	}
	
}
