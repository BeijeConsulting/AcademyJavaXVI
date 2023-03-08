package it.beije.neumann.ecommerce_shoes.model;


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
	
	@Column(name = "instructions")
	private String instructions;
	
	
	

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
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

	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", name_surname: ").append(nameSurname)
				.append(", country: ").append(country)
				.append(", street_address: ").append(streetAddress)
				.append(", telephone: ").append(telephone)
				.append(", created_at: ").append(createdAt)
				.append(", disabled_at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}
}