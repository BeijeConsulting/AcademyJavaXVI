package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.UserRepository;


@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		System.out.println("GET /register");		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postLogin(Model model,
							@RequestParam(required = true) String name,
							@RequestParam(required = true) String surname,
							@RequestParam(required = true) String email, 
							@RequestParam(required = true) String password,
							@RequestParam(required = true) String telephone,
							@RequestParam(required = true) String birthdate) throws IOException {
		System.out.println("POST /register");
		
		User u = new User();
		u.setName(name);
		u.setSurname(surname);
		u.setEmail(email);
		u.setPassword(password);
		u.setTelephone(telephone);
		u.setBirthdate()
		
		if (risultati.isEmpty()) {
			model.addAttribute("error", "Invalid Credentials!");
			return "login";
		}
		else {
			return "index";
		}
	}
}
