package it.beije.neumann.db3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "addresses")
public class Address {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "label", length = 100)
	private String label;

	@Column(name = "name_surname", nullable = false, length = 100)
	private String fullName;

	@Column(name = "country", nullable = false, length = 100)
	private String country;

	@Column(name = "street_address", nullable = false, length = 100)
	private String streetAddress;

	@Column(name = "telephone", nullable = false, length = 100)
	private String telephone;

	@Column(name = "zipcode", nullable = false, length = 5)
	private String zipcode;

	@Column(name = "instructions", columnDefinition = "text")
	private String instructions;

	@Column(name = "created_at", nullable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "user_id", nullable = false)
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
				.append(" Address Id: ").append(id).append(",")
				.append(" Label: ").append(label).append(",")
				.append(" Full Name: ").append(fullName).append(",")
				.append(" Country: ").append(country).append(",")
				.append(" Street Address: ").append(streetAddress).append(",")
				.append(" Telephone: ").append(telephone).append(",")
				.append(" Zipcode: ").append(zipcode).append(",")
				.append(" Instructions: ").append(instructions).append(",")
				.append(" Created At: ").append(createdAt).append(",")
				.append(" Disabled At: ").append(disabledAt).append(",")
				.append(" User Id: ").append(userId).append("");
		
		return builder.toString();
	}
	
	//Utilità
	public void copyValuesOf(Address other) {
		this.setLabel(other.getLabel());
		this.setFullName(other.getFullName());
		this.setCountry(other.getCountry());
		this.setStreetAddress(other.getStreetAddress());
		this.setTelephone(other.getTelephone());
		this.setZipcode(other.getZipcode());
		this.setInstructions(other.getInstructions());
		this.setUserId(other.getUserId());
	}

}