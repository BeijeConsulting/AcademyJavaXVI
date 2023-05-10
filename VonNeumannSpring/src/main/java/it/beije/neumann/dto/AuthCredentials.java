package it.beije.neumann.dto;

import java.io.Serializable;

public class AuthCredentials implements Serializable {
	
	private static final long serialVersionUID = -3519905797046907320L;

	private String email;
    private String password;
    
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
}
