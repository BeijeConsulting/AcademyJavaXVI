package it.beije.neumann.iaria_ecommerce.model;

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
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
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
	
	@OneToMany(targetEntity = Addresses.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Addresses> addresses;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setDisableAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
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
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Addresses> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Addresses> addresses) {
		this.addresses = addresses;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" ID: ").append(id)
				.append(", Created: ").append(createdAt)
				.append(", Disabled: ").append(disabledAt)
				.append(", Name: ").append(name)
				.append(", Surname: ").append(surname)
				.append(", Email: ").append(email)
				.append(", Password: ").append(password)
				.append(", Telephone: ").append(telephone)
				.append(", Birth date: ").append(birthDate)
				.append(", Addresses: ").append(addresses)
				.append("}");

		return builder.toString();
	}
}
