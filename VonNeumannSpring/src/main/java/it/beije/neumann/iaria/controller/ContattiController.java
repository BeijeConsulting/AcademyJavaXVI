package it.beije.neumann.iaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.iaria.model.IariaContatto;
import it.beije.neumann.iaria.repository.IariaContattoRepository;
import it.beije.neumann.model.Contatto;


@Controller
public class ContattiController {
	
	@Autowired
	private IariaContattoRepository iariaContattoRepository;

	@RequestMapping(value = "/iaria/lista_contatti", method = RequestMethod.GET)
	public String Lettura(Model model) {
		System.out.println("GET lettura/lista_contatti");

		//Lettura dati
		List<IariaContatto> contatti = iariaContattoRepository.findAll();
						
		model.addAttribute("lista", contatti);
		
		return "iaria/lista_contatti";
	}
	
	/*
	@RequestMapping(value = "/form_contatto", method = RequestMethod.GET)
	public String formContatto() {
		System.out.println("GET /form_contatto");
		return "iaria/form_contatto";
	}

	@RequestMapping(value = "/form_contatto", method = RequestMethod.POST)
	public String formContatto(Model model, @RequestParam String name, @RequestParam String surname,
			@RequestParam String telephone, @RequestParam String email) {
		System.out.println("POST /form_contatto");
		
		//String name = request.getParameter("nome");
		System.out.println("name : " + name);
		System.out.println("surname : " + surname);
		System.out.println("telephone : " + telephone);
		System.out.println("email : " + email);
		
		Contatto contatto = new Contatto();
		contatto.setName(name);
		contatto.setSurname(surname);
		contatto.setTelephone(telephone);
		contatto.setEmail(email);
		
		model.addAttribute("contatto", contatto);
		
		return "iaria/form_contatto";
	}*/
	
}
