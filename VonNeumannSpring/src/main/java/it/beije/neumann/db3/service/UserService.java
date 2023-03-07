package it.beije.neumann.db3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	public boolean userAlreadyPresent(String email) {
		User u = userRepo.findByEmail(email);
		return u!=null? true : false;
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
