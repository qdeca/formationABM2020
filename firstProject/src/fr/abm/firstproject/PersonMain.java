package fr.abm.firstproject;

import java.time.LocalDate;

import fr.abm.firstproject.utils.DateUtils;

public class PersonMain {

	public static void main(String[] args) {
//		Person firstPerson = new Person("Dupont", "Jean", 42);
//		Person secondPerson = new Person("Dubois", "Jean", 40);
//		Person thirdPerson = new Person();
//		thirdPerson.setName("Durand");
//		thirdPerson.setSurname("Jean");
//		thirdPerson.setAge(38);
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);
//		secondPerson.mood = "sad";
//		System.out.println(firstPerson.mood);
//		System.out.println(secondPerson.mood);

		LocalDate today = LocalDate.now();
		LocalDate firstOfMonth = DateUtils.getFirstDayOfMonth(today);
		System.out.println(firstOfMonth);
	}
	
}
