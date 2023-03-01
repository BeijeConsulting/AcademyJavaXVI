package it.beije.neumann.mercuri.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.mercuri.repository.MyContattoRepository;
import it.beije.neumann.model.Contatto;



@Controller
public class RubricaController {
	
	@Autowired
	private MyContattoRepository contattoRepository;

	@RequestMapping(value = "mercuri/lista_contatti", method = RequestMethod.GET)
	public String prova(Model model, @RequestParam(required = false) String surname) {
		System.out.println("GET mercuri/lista_contatti");
		
//		Contatto contatto = new Contatto();
//		contatto.setName("Paolino");
//		contatto.setSurname("Paperino");
//		contatto.setTelephone("3334445556");
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		contatti.add(contatto);
		

		List<Contatto> contatti;
		if (surname != null) {
			contatti = contattoRepository.findBySurname(surname);
		} else {
			contatti = contattoRepository.findAll();
		}

						
		model.addAttribute("lista", contatti);
		
		return "lista_contatti";
	}
	
	@RequestMapping(value = "mercuri/form_contatto", method = RequestMethod.GET)
	public String formContatto() {
		System.out.println("GET mercuri/form_contatto");
		
		return "form_contatto";
	}

	@RequestMapping(value = "mercuri/form_contatto", method = RequestMethod.POST)
	//public String formContatto(Model model, @RequestParam(value = "nome", required = false) String name) {
	public String formContatto(Model model, @RequestParam String name, @RequestParam String surname,
			@RequestParam String telephone, @RequestParam String email) {
		System.out.println("POST mercuri/form_contatto");
		
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
		
		return "form_contatto";
	}

	@RequestMapping(value = "mercuri/insert_contatto", method = RequestMethod.POST)
	public String insertContatto(Model model, Contatto contatto) {
		System.out.println("POST mercuri/insert_contatto");
		
		System.out.println("contatto : " + contatto);
		
		model.addAttribute("contatto", contatto);
		
		contattoRepository.save(contatto);
		
		return "form_contatto";
	}
}
