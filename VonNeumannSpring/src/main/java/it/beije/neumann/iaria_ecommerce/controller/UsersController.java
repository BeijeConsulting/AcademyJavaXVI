package it.beije.neumann.iaria_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.iaria_ecommerce.model.Users;
import it.beije.neumann.iaria_ecommerce.repository.UsersRepository;


@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;

	@RequestMapping(value = "/iaria/ecommerce/lista_utenti", method = RequestMethod.GET)
	public String Lettura(Model model) {
		System.out.println("In");

		//Lettura dati
		List<Users> users = usersRepository.findAll();
						
		model.addAttribute("users", users);
		
		return "iaria/ecommerce/lista_utenti";
	}
	
}
