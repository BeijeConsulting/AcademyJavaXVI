package it.beije.neumann.elassl.contatti;

import java.util.Objects;
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
	private String email;s
	@Column(name = "note", columnDefinition="text")
	private String note;
	
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

	public void setAttributes(String format, String delimiter, String[] attributes) {
		String keys[]= format.split(delimiter);
		for(int i=0; i<attributes.length;i++) {
			switch(keys[i].toLowerCase()) {
			case "name":
				setName(attributes[i]);
				break;
			case "surname":
				setSurname(attributes[i]);
				break;
			case "telephone":
				setTelephone(attributes[i]);
				break;
			case "email":
				setEmail(attributes[i]);
				break;
			case "note":
				setNote(attributes[i]);
				break;
			default:
				throw new IllegalArgumentException("Invalid CSV format");
			}
		}
	}
	
	public Contatto(int id, String name, String surname, String telephone, String email, String note) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.note = note;
	}
	public Contatto(String name, String surname, String telephone, String email, String note) {
		super();
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.note = note;
	}
	public Contatto() {
		super();
	}
	public String toString() {
//		StringBuilder builder = new StringBuilder("{");
//		builder.append(" name: ").append(name);
//		builder.append(", surname: ").append(surname);
//		builder.append(", telephone: ").append(telephone);
//		builder.append(", email: ").append(email);
//		builder.append(", note: ").append(note);
//		builder.append("}");

		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(" name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", telephone: ").append(telephone)
				.append(", email: ").append(email)
				.append(", note: ").append(note)
				.append("}");

		return builder.toString();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean equals(Object obj) {
	     if (this == obj) return true; // if it's the same object return true
	     if (obj == null || getClass() != obj.getClass()) return false; // if null or different class return false
	     Contatto other = (Contatto) obj; // casting of contatto
	     return surname.equals(other.surname) && name.equals(other.name); // true if they have same name and surname
	   }
}