package it.beije.neumann.mercuri.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
		
	@Column(name = "label")
	private String label;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@OneToMany(targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Address> adresses;

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", label: ").append(label)
				.append(", name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", email: ").append(email)
				.append(", password: ").append(password)
				.append(", telephone: ").append(telephone)
				.append(", birth date: ").append(birthDate)
				.append("}");

		return builder.toString();
	}
}
