package it.beije.neumann.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "contatti")
@JsonInclude(Include.NON_NULL)
public class Contatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "note", columnDefinition="text")
	private String note;
	
	@Transient
	private String completeName;
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getNote() {
		return note;
	}

	public String getCompleteName() {
		return nome + " " + cognome;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
//	public String getCompleteName() {
//		return name + " " + surname;
//	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("- Nome: ").append(nome)
				.append("\n- Cognome: ").append(cognome)
				.append("\n- Telefono: ").append(telefono)
				.append("\n- Email: ").append(email)
				.append("\n- Note: ").append(note);
		return builder.toString();
	}
}
