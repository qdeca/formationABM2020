package fr.abm.firstproject.entity;

import java.util.Date;

public class Person extends Object implements Comparable<Person>{
	
	public static String mood = "happy";
	
	private String name;
	
	private String surname;
	
	private int age;

	private Address address;
	
	private Date birthDate;
	
	
	//exemple de constructeur
	public Person(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Person() {
		
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int compareTo(Person o) {
		
		return this.getName().compareTo(o.getName());
	}
	
	

	
}
