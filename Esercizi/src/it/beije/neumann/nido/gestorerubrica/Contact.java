package it.beije.neumann.nido.gestorerubrica;

import java.util.Objects;

public class Contact {

	private int id;
	private String surname;
	private String name;
	private int age;
	private String telephone;
	private String email;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder("{").append(" Name: ").append(name).append(", Surname: ")
				.append(surname).append(", Age: ").append(age).append(", Telephone: ").append(telephone)
				.append(", Email: ").append(email).append(", Note: ").append(note).append("}");

		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, name, note, surname, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

}
