package it.beije.neumann.nidospring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "label")
	private String label;

	@Column(name = "name_surname")
	private String fullName;

	@Column(name = "country")
	private String country;

	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "instructions", columnDefinition = "text")
	private String instructions;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
//	@ManyToOne
	@Column(name = "user_id")
	private Integer userId;

	// Getters-Setters
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Address Id: ").append(id).append(",<br>")
				.append(" Label: ").append(label).append(",<br>")
				.append(" Full Name: ").append(fullName).append(",<br>")
				.append(" Country: ").append(country).append(",<br>")
				.append(" Street Address: ").append(streetAddress).append(",<br>")
				.append(" Telephone: ").append(telephone).append(",<br>")
				.append(" Zipcode: ").append(zipcode).append(",<br>")
				.append(" Instructions: ").append(instructions).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append(",<br>")
				.append(" User Id: ").append(userId).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Label: ").append(label)
				.append(", Full Name: ").append(fullName)
				.append(", Country: ").append(country)
				.append(", Street Address: ").append(streetAddress)
				.append(", Telephone: ").append(telephone)
				.append(", Zipcode: ").append(zipcode)
				.append(", Instructions: ").append(instructions)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append(", User Id: ").append(userId)
				.append("}");
		
		return builder.toString();
	}
	 * 
	 */

}
