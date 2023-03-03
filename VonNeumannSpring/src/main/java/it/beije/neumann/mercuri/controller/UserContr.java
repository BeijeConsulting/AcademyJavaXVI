package it.beije.neumann.mercuri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.mercuri.model.User;
import it.beije.neumann.mercuri.repository.UserRepo;


@Controller
public class UserContr {
	

	@Autowired
	private UserRepo userRepo;

	@RequestMapping(value = "mercuri/lista_utenti", method = RequestMethod.GET)
	public String prova(Model model, @RequestParam(required = false) String name) {
		System.out.println("GET mercuri/lista_utenti");
		
		List<User> utenti = userRepo.findAll();
		System.out.println(utenti);
		
		model.addAttribute("users", utenti);
		return "mercuri/lista_utenti";
	}

}