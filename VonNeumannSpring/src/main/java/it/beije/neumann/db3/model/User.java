package it.beije.neumann.db3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Cacheable(false)
@Table(name = "users")
public class User {

	//Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "surname", nullable = false, length = 100)
	private String surname;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "telephone", length = 100)
	private String telephone;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@Column(name="birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "created_at", nullable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdAt;
	
	@Column(name="disabled_at")
	private LocalDateTime disabledAt;
	

	@OneToOne(targetEntity = ShoppingCart.class, fetch = FetchType.LAZY)
		@JoinColumn(name = "id")
	private ShoppingCart shoppingCart;
	@OneToMany(targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Address> addresses;
	

	//Getters-Setters
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", surname=" + surname + ", name=" + name + ", telephone=" + telephone + ", email="
				+ email + ", password=" + password + ", birthDate=" + birthDate + ", createdAt=" + createdAt
				+ ", disabledAt=" + disabledAt + ", shoppingCart=" + shoppingCart + ", addresses=" + addresses + "]";
	}

	public String getTableFormat() {
		StringBuilder table = new StringBuilder()
				.append(name).append("</td>")
				.append("<td>").append(surname).append("</td>")
				.append("<td>").append(telephone).append("</td>")
				.append("<td>").append(email).append("</td>")
				.append("<td>").append(birthDate);
		
		return table.toString();
	}
	
	//Utilità
	public void copyValuesOf(User other) {
		this.setName(other.getName());
		this.setSurname(other.getSurname());
		this.setEmail(other.getEmail());
		this.setPassword(other.getPassword());
		this.setTelephone(other.getTelephone());
		this.setBirthDate(other.getBirthDate());
	}
}