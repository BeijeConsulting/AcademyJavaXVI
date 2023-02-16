package it.beije.neumann.vanoli.rubrica;

public class Contatto {

	private int id;
	private String name;
	private String surname;
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
		StringBuilder builder = new StringBuilder()
				.append("- Nome: ").append(name)
				.append("\n- Cognome: ").append(surname)
				.append("\n- Telefono: ").append(telephone)
				.append("\n- Email: ").append(email)
				.append("\n- Note: ").append(note);
		return builder.toString();
	}
}
