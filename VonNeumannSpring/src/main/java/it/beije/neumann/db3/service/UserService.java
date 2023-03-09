package it.beije.neumann.db3.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;

import it.beije.neumann.db3.model.Address;

import it.beije.neumann.db3.model.User;

import it.beije.neumann.db3.repository.ShoppingCartRepository;

import it.beije.neumann.db3.repository.AddressRepository;

import it.beije.neumann.db3.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private AddressRepository addressRepo;
	
	//Temp, non so se va bene metterlo qui
	public boolean isUserLogged(HttpSession session) {
		return (User)session.getAttribute("logged_user")!=null? true : false;
	}
	
	public User getLoggedUser(HttpSession session) {
		return (User)session.getAttribute("logged_user");
	}

	public User findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

	public boolean userAlreadyPresent(String email) {
		User u = userRepo.findByEmail(email);
		return u != null ? true : false;
	}

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Transactional
	public ShoppingCart getShoppingCart(Integer user_id) { // ritorna null l'id dell'utente non è presente
		ShoppingCart s = null;
		Optional<User> user = userRepo.findById(user_id);
		if (user.isPresent()) {
			System.out.print(user.get());
			Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findByUserId(user_id);
			
			if(shoppingCart.isPresent()) {
				s=shoppingCart.get();
			}
			else {
				s = new ShoppingCart();
				s.setUserId(user_id);
				s.setId(0);
				System.out.println("ShoppingCart: " + s);
				shoppingCartRepository.save(s);
			}
		}
		
		System.out.print(s);
		return s;
	}

	public User findById(Integer id) {
		Optional<User> u = userRepo.findById(id);
		return u.get(); // Essendo un logged user, non tornerà mai null [eventualmente provare]
	}

}
