package it.beije.neumann.model;


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
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String lastname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "telephone")
    private String telephone;
    

    @Column(name = "birth_date")
    private String birthDate;
    
	@OneToMany(targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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
    	
    	createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
    	
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", name=" + name
                + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", telephone=" + telephone
                + ", birthDate=" + birthDate + ", addresses" + addresses + "]";
    }
    
}
