package it.beije.neumann.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.neumann.model.ShoppingCart;
import it.beije.neumann.model.User;
import it.beije.neumann.repository.ShoppingCartReposistory;
import it.beije.neumann.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShoppingCartReposistory cartRepository;
	
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
	public User findByEmailAndPassword(String email, String password){
		
		return userRepository.findByEmailAndPassword(email, password).get(0);
	}
	
	
	public int addAccount (User user) {
		
		if (userRepository.findByEmail(user.getEmail()).size() == 0) {
			userRepository.save(user);
			ShoppingCart cart = new ShoppingCart();
			
			cart.setCreatedAt(null);
			cart.setUserId(user.getId());
			cartRepository.save(cart);
		} else return -1;
		
		return 0;
				
	}
	
}
