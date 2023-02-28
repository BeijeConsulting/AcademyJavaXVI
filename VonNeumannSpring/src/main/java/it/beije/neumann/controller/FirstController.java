package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.repository.ContattoRepository;


@Controller
public class FirstController {
	
	@Autowired
	private ContattoRepository contattoRepository;

	@RequestMapping(value = "/lista_contatti", method = RequestMethod.GET)
	public String prova(Model model) {
		System.out.println("GET /lista_contatti");
		
//		Contatto contatto = new Contatto();
//		contatto.setName("Paolino");
//		contatto.setSurname("Paperino");
//		contatto.setTelephone("3334445556");
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		contatti.add(contatto);
		
		List<Contatto> contatti = contattoRepository.findAll();
						
		model.addAttribute("lista", contatti);
		
		return "lista_contatti";
	}	

}
