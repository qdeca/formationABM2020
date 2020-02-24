package fr.abm.firstproject.entity;

public class Address {

	private int streetNumber;
	
	private String streetName;
	
	private String phoneNumber;
	
	private String mail;

	public Address(int streetNumber, String streetName, String phoneNumber, String mail) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
	
	
}
