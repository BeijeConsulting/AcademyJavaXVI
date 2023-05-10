package it.beije.neumann.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.User;
import it.beije.neumann.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// SPRING SECURITY
	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			User user = userRepository.findByEmail(email);
			if (user == null) new UsernameNotFoundException("email: " + email + " not found");

			return user;
		} catch (Exception e) {
			throw e;
		}
	}

}
