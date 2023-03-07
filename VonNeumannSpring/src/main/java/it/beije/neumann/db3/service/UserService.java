package it.beije.neumann.db3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.repository.AddressRepository;
import it.beije.neumann.db3.repository.UserRepository;
import it.beije.neumann.model.Order;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
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
	
	public User findById(Integer id) {
		Optional<User> u = userRepo.findById(id);
		return u.get(); //Essendo un logged user, non tornerà mai null (spero)
	}
	
	//Temp
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
}
