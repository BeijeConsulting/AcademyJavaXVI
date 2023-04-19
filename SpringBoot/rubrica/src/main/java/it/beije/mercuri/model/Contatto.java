package it.beije.mercuri.model;

public class Contatto {
	
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	
	public Contatto() {
		System.out.println("created instance of Contact");
	}
	
	public Contatto(String name, String surname, String email, String phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name : ").append(name).append('\n');
		builder.append("surname : ").append(surname).append('\n');
		builder.append("email : ").append(email).append('\n');
		builder.append("phoneNumber : ").append(phoneNumber).append('\n');
		return builder.toString();
	}
}
