package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.User;
import it.beije.neumann.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/lista_users", method = RequestMethod.GET)
	public String listaUser(Model model) {
		System.out.println("GET /lista_users");
		
		List<User> users = userRepository.findAll();
		System.out.println(users);
		
		model.addAttribute("users", users);
		
		return "lista_users";
	}
}