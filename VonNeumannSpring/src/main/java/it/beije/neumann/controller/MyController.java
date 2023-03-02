package it.beije.neumann.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	/**
	 * metodi che, attraverso un form su jsp, aggiungono un contatto al database
	 * @return 
	 */
	
	@RequestMapping(value = "/visualizza_form", method = RequestMethod.GET)
	public String visualizzaForm() {
		System.out.println("GET /visualizza_form");
		
		return "visualizza_form";
	}

	
	@RequestMapping(value="/visualizza_form",method= RequestMethod.POST)
	public String visualizzaForm(Model model, @RequestParam String name, @RequestParam String surname,
			@RequestParam String telephone, @RequestParam String email) {
         
	    System.out.println("POST /visualizza_form");
		
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
		
		
		return "visualizza_form";
		
		
	}
	
	
	@RequestMapping(value="/inserisci_contatto", method=RequestMethod.POST)
	public String inserisciContatto(Model model, Contatto contatto)
	{
        System.out.println("POST /form_contatto");
		
		System.out.println("contatto : " + contatto);
		model.addAttribute("contatto", contatto);
		
		contattoRepository.save(contatto);
		
		return "visualizza_form";
	}
	
	@RequestMapping(value="/final_message",method=RequestMethod.GET)
	
	public String finalContatto()
	{
		System.out.println("final_message");
		return "final_message";
	}
	
	
	
}
