package it.beije.neumann.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.neumann.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
		
	public boolean isAuthenticated(String email, String password) {
		
		if (userRepository.findByEmailAndPassword(email, password).size() == 1)
			return true;
		
		return false;
	}
	
	public boolean isNewEmail (String email) {
		
		if (userRepository.findByEmail(email).size() == 1)
			return false;
		
		return true;
	}
	
}
