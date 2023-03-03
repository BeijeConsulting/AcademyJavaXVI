package it.beije.neumann.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.repository.ContattoRepository;


@Controller
public class FirstController {
	
	@Autowired
	private ContattoRepository contattoRepository;

	@RequestMapping(value = "/lista_contatti", method = RequestMethod.GET)
	public String prova(Model model, @RequestParam(required = false) String surname) {
		System.out.println("GET /lista_contatti");
		
//		Contatto contatto = new Contatto();
//		contatto.setName("Paolino");
//		contatto.setSurname("Paperino");
//		contatto.setTelephone("3334445556");
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		contatti.add(contatto);
		
		List<Contatto> contatti;
		if (surname != null) {
			contatti = contattoRepository.findByCognome(surname);
		} else {
			contatti = contattoRepository.findAll();
		}
		 
						
		model.addAttribute("lista", contatti);
		
		return "lista_contatti";
	}
	
	@RequestMapping(value = "/form_contatto", method = RequestMethod.GET)
	public String formContatto() {
		System.out.println("GET /form_contatto");
		
		return "form_contatto";
	}

	@RequestMapping(value = "/form_contatto", method = RequestMethod.POST)
	//public String formContatto(Model model, @RequestParam(value = "nome", required = false) String name) {
	public String formContatto(Model model, @RequestParam String name, @RequestParam String surname,
			@RequestParam String telephone, @RequestParam String email) {
		System.out.println("POST /form_contatto");
		
		//String name = request.getParameter("nome");
		System.out.println("name : " + name);
		System.out.println("surname : " + surname);
		System.out.println("telephone : " + telephone);
		System.out.println("email : " + email);
		
		Contatto contatto = new Contatto();
		contatto.setNome(name);
		contatto.setCognome(surname);
		contatto.setTelefono(telephone);
		contatto.setEmail(email);
		
		model.addAttribute("contatto", contatto);
		
		return "form_contatto";
	}

	@RequestMapping(value = "/insert_contatto", method = RequestMethod.POST)
	public String insertContatto(Model model, Contatto contatto) {
		System.out.println("POST /form_contatto");
		
		System.out.println("contatto : " + contatto);
		
		model.addAttribute("contatto", contatto);
		
		return "form_contatto";
	}
}
