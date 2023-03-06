package it.beije.neumann.db3.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	//Properties mapping
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
	
	@Column(name = "password")
	private String password;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@Column(name="disabled_at")
	private LocalDateTime disabledAt;
	
	@OneToMany(targetEntity = Address.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	private List<Address> addresses;
	
	//TODO Collegamento col carrello
	
	//Getters-Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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

//	public List<Address> getAddresses() {
//		return addresses;
//	}
//
//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}

	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" User Id: ").append(id).append(",\n")
				.append(" Name: ").append(name).append(",\n")
				.append(" Surname: ").append(surname).append(",\n")
				.append(" Telephone: ").append(telephone).append(",\n")
				.append(" E-mail: ").append(email).append(",\n")
				.append(" Password: ").append(password).append(",\n")
				.append(" Birth Date: ").append(birthDate).append(",\n")
				.append(" Created At: ").append(createdAt).append(",\n")
				.append(" Disabled At: ").append(disabledAt).append("\n");
//				.append(" Addresses: ").append(addresses).append("\n")
		
		return builder.toString();
	}
	
	public String getTableFormat() {
		StringBuilder table = new StringBuilder()
							   .append(id).append("</td>")
				.append("<td>").append(name).append("</td>")
				.append("<td>").append(surname).append("</td>")
				.append("<td>").append(telephone).append("</td>")
				.append("<td>").append(email).append("</td>")
				.append("<td>").append(password).append("</td>")
				.append("<td>").append(birthDate).append("</td>")
				.append("<td>").append(createdAt).append("</td>")
				.append("<td>").append(disabledAt);
//				.append("<td>").append(addresses).append("</td>")
		
		return table.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Name: ").append(name)
				.append(", Surname: ").append(surname)
				.append(", Telephone: ").append(telephone)
				.append(", E-mail: ").append(email)
				.append(", Password: ").append(password)
				.append(", Birth Date: ").append(birthDate)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append("}");
		
		return builder.toString();
	}
	 */
}