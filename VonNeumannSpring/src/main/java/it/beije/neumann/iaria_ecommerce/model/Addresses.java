package it.beije.neumann.iaria_ecommerce.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "addresses")
public class Addresses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
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
	private String zipcode;
	
	@Column(name = "instructions", columnDefinition="text")
	private String instructions;
	
	@Column(name = "user_id")
	private Integer userId;
	
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
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" ID: ").append(id)
				.append(", Created: ").append(createdAt)
				.append(", Disabled: ").append(disabledAt)
				.append(", Label: ").append(label)
				.append(", Name and Surname: ").append(nameSurname)
				.append(", Country: ").append(country)
				.append(", Street address: ").append(streetAddress)
				.append(", Telephone: ").append(telephone)
				.append(", Zipcode: ").append(zipcode)
				.append(", Instructions: ").append(instructions)
				.append(", User id: ").append(userId)
				.append("}");

		return builder.toString();
	}
}
