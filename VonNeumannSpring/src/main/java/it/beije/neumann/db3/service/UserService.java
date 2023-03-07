package it.beije.neumann.db3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.repository.ShoppingCartRepository;
import it.beije.neumann.db3.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	@Transactional
	public ShoppingCart getShoppingCart(Integer user_id) { //ritorna null l'id dell'utente non è presente
		ShoppingCart s=null;
		Optional<User> user = userRepo.findById(user_id);
		if(user.isPresent()) {
			s = user.get().getShoppingCart();
			if (s==null) {
				s = new ShoppingCart();
				s.setUserId(user_id);
				s.setId(0);
				System.out.println("ShoppingCart: "+s);
				shoppingCartRepository.save(s);
			}
		}
		for(ShoppingCartItem sc: s.getShoppingCartItem()) {
			System.out.print(sc);
		}
		return s;
	}
}
