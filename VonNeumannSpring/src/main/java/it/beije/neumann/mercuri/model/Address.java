package it.beije.neumann.mercuri.model;

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
	
	@Column(name = "name_surname")
	private String nameSurname;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "zipcode")
	private String zipCode;
	
	@Column(name = "instructions")
	private String instructions;
	
	@Column(name = "user_id")
	private String userId;

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

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", label: ").append(label)
				.append(", nameSurname: ").append(nameSurname)
				.append(", country: ").append(country)
				.append(", streetAddress: ").append(streetAddress)
				.append(", telephone: ").append(telephone)
				.append(", zipCode: ").append(zipCode)
				.append(", instructions: ").append(instructions)
				.append(", userId: ").append(userId)
				.append("}");

		return builder.toString();
	}
	
}
