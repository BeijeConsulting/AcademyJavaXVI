package it.beije.neumann.web.esercizi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contatti")
public class Contatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "cognome")
	private String surname;
	
	@Column(name = "telefono")
	private String telephone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "note", columnDefinition="text")
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

		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", telephone: ").append(telephone)
				.append(", email: ").append(email)
				.append(", note: ").append(note)
				.append("}");

		return builder.toString();
	}
}