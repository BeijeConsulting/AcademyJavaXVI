package it.beije.neumann.model;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = -3252125086990655665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

//	 @Column(name="disable_date")
//	 private LocalDateTime disableDate;
//
//	public LocalDateTime getDisableDate() {
//		return disableDate;
//	}
//
//	public void setDisableDate(LocalDateTime disableDate) {
//		this.disableDate = disableDate;
//	}
//
//	@JsonGetter(value = "disableDate")
//	public LocalDateTime getDisableDateString() {
//		return disableDate;
//	}
//
//	@JsonSetter(value = "disableDate")
//	public void setDisableDateString(String data) {
//		this.disableDate = LocalDateTime.parse(data, DateTimeFormatter.ISO_DATE);
//	}	 
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", email: ").append(email)
				.append("}");

		return builder.toString();
	}



	// SPRING SECURITY
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_authority",
		joinColumns = {	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id", nullable = false, updatable = false) }
	)
	@JsonIgnore
	private List<Authority> authorityEntity = new ArrayList<>();

	private List<String> createStringAuth() {
		List<String> list = new ArrayList<>();
		for (Authority r : authorityEntity)
			list.add(r.getAuthority());
		return list;
	}

	@JsonIgnore
	public List<String> getAuthorityList() {
		return createStringAuth();
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return createStringAuth().stream().map(SimpleGrantedAuthority::new).collect(toList());
	}

	// Serializable methods
	@Override
	public String getUsername() {
		return this.email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}

	
