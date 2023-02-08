package it.beije.neumann.vanoli._02_08;

public class Contatto {

	private String name;
	private String surname;
	private String telephone;
	private String email;
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

	public String toString() {
//		StringBuilder builder = new StringBuilder("{");
//		builder.append(" name: ").append(name);
//		builder.append(", surname: ").append(surname);
//		builder.append(", telephone: ").append(telephone);
//		builder.append(", email: ").append(email);
//		builder.append(", note: ").append(note);
//		builder.append("}");

		StringBuilder builder = new StringBuilder("{")
				.append(" name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", telephone: ").append(telephone)
				.append(", email: ").append(email)
				.append(", note: ").append(note)
				.append("}");

		return builder.toString();
	}
}
