package it.beije.neumann.db3.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;

import it.beije.neumann.db3.model.Address;

import it.beije.neumann.db3.model.UserD;

import it.beije.neumann.db3.repository.ShoppingCartRepository;

import it.beije.neumann.db3.repository.AddressRepository;

import it.beije.neumann.db3.repository.UserRepositoryD;

@Service
public class UserServiceD {

	@Autowired
	private UserRepositoryD userRepo;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	//Temp, non so se va bene metterlo qui
	public boolean isUserLogged(HttpSession session) {
		return (UserD)session.getAttribute("logged_user")!=null? true : false;
	}
	
	public UserD getLoggedUser(HttpSession session) {
		return (UserD)session.getAttribute("logged_user");
	}

	public UserD findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

	public boolean userAlreadyPresent(String email) {
		UserD u = userRepo.findByEmail(email);
		return u != null ? true : false;
	}

	public UserD saveUser(UserD userD) {
		return userRepo.save(userD);
	}

	@Transactional
	public ShoppingCart getShoppingCart(Integer user_id) { // ritorna null l'id dell'utente non è presente
		ShoppingCart s = null;
		Optional<UserD> userD = userRepo.findById(user_id);
		if (userD.isPresent()) {
			System.out.print(userD.get());
			Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findByUserId(user_id);
			
			if(shoppingCart.isPresent()) {
				s=shoppingCart.get();
			}
			else {
				s = new ShoppingCart();
				s.setUserId(user_id);
				//s.setId(0);
				System.out.println("ShoppingCart: " + s);
				shoppingCartRepository.save(s);
			}
		}
		
		System.out.print(s);
		return s;
	}

	@Transactional
	public UserD findById(Integer id) {
		Optional<UserD> u = userRepo.findById(id);
		System.out.println(u);
		return u.get(); // Essendo un logged user, non tornerà mai null [eventualmente provare]
	}

}
