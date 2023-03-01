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
	

	@RequestMapping(value = "/iaria/form_contatto", method = RequestMethod.GET)
	public String formContatto() {
		System.out.println("GET /form_contatto");
		return "iaria/form_contatto";
	}

	@RequestMapping(value = "/iaria/form_contatto", method = RequestMethod.POST)
	public String formContatto(Model model, @RequestParam String nome, @RequestParam String cognome,
			@RequestParam String telefono, @RequestParam String email, @RequestParam String note) {
		System.out.println("POST /form_contatto");

		System.out.println("Nome : " + nome);
		System.out.println("Cognome : " + cognome);
		System.out.println("Telefono : " + telefono);
		System.out.println("Email : " + email);
		System.out.println("Note : " + note);
		
		IariaContatto contatto = new IariaContatto();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		contatto.setNote(note);
		
		model.addAttribute("contatto", contatto);
		
		return "iaria/form_contatto";
	}
	
	@RequestMapping(value = "/iaria/insert_contatto", method = RequestMethod.POST)
	public String insertContatto(Model model, IariaContatto contatto) {
		System.out.println("POST /form_contatto");
		
		System.out.println("contatto : " + contatto);
		
		model.addAttribute("contatto", contatto);
		
		return "iaria/form_contatto";
	}
	
}
