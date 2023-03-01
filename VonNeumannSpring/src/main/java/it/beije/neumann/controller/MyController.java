package it.beije.neumann.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.repository.ContattoRepository;

@Controller
public class MyController 
{
	@Autowired
	private ContattoRepository contattoRepository;
	
	
	@RequestMapping(value ="/vedi_lista", method = RequestMethod.GET)
	public String prova(Model model) {
		System.out.println("GET /vedi_lista");
		

		
		List<Contatto> contatti = contattoRepository.findBySurname("Verzaschi");
		
		//System.out.println(contatti);
						
		model.addAttribute("lista", contatti);
		
		return "vedi_lista";
	}	
}
