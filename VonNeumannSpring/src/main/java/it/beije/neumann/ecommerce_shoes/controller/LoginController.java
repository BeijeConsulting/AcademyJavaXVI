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
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		System.out.println("GET /login");		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model, @RequestParam(required = true) String email, @RequestParam(required = true) String password) throws IOException {
		System.out.println("POST /login");
		List<User> risultati = userRepository.findByEmailAndPassword(email, password);
		if (risultati.isEmpty()) {
			model.addAttribute("error", "Invalid Credentials!");
			return "login";
		}
		else {
			return "index";
		}
	}
}
