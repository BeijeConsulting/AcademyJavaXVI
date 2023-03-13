package it.beije.neumann.nidospring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rubricacompleta")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "surname")
	private String surname;

	@Column(name = "name")
	private String name;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "email")
	private String email;

	@Column(name = "note", columnDefinition = "text")
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getCompleteName() {
		return name + " " + surname;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder("{").append(" ID: ").append(id).append(", Name: ").append(name)
				.append(", Surname: ").append(surname).append(", Telephone: ").append(telephone).append(", Email: ")
				.append(email).append(", Note: ").append(note).append("}");

		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, note, surname, telephone);
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
