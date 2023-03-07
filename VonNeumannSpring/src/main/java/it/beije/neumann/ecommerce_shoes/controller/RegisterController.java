package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartRepository;
import it.beije.neumann.ecommerce_shoes.repository.UserRepository;


@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		System.out.println("GET /register");		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request,
							Model model,
							@RequestParam(required = true) String name,
							@RequestParam(required = true) String surname,
							@RequestParam(required = true) String email, 
							@RequestParam(required = true) String password,
							@RequestParam(required = true) String telephone,
							@RequestParam(required = true) String birthdate) throws IOException {
		System.out.println("POST /register");
		
		HttpSession session = request.getSession();
		
		//Creazione utente
		User u = new User();
		u.setName(name);
		u.setSurname(surname);
		u.setEmail(email);
		u.setPassword(password);
		u.setTelephone(telephone);
		u.setBirthdate(LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		u.setCreatedAt(LocalDateTime.now());
		userRepository.save(u);
		// Siccome mi serve l'id assegnato allo user, mi prendo dal database lo user che ho appena creato
		u = userRepository.findByEmailAndPassword(email, password).get(0);
		// e adesso creo il carrello per l'utente
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(u);
		cart.setCreatedAt(LocalDateTime.now());
		shoppingCartRepository.save(cart);
		
		session.setAttribute("user", u);
		
		return "index";
	}
}
