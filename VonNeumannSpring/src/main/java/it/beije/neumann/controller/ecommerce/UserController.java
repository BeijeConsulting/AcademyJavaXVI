package it.beije.neumann.controller.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.ecommerce.Users;
import it.beije.neumann.repository.ecommerce.UsersRepository;

@Controller
public class UserController {

	@Autowired
	private UsersRepository userRepository;

	@RequestMapping(value = "/lista_users", method = RequestMethod.GET)
	public String listaOrdini(Model model) {
		System.out.println("GET /lista_users");
		
		List<Users> users = userRepository.findAll();
		System.out.println(users);
		
		model.addAttribute("users", users);
		
		return "lista_users";
	}
}
