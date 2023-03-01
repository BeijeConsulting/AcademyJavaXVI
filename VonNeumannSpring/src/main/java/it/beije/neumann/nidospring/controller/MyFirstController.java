package it.beije.neumann.nidospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.nidospring.model.Contact;
import it.beije.neumann.nidospring.repository.ContactRepository;


@Controller
public class MyFirstController {
	
	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/nidospring/lista_contatti", method = RequestMethod.GET)
	public String prova(Model model) {
		System.out.println("GET /lista_contatti");
		
//		List<Contact> contacts = contactRepository.findAll();
//		List<Contact> contacts = contactRepository.findByNameOrderByNameAsc();
		List<Contact> contacts = contactRepository.findAll(Sort.by("name").descending());
						
		model.addAttribute("lista", contacts);
		
		return "nidoviews/lista_contatti";
	}	
	
	@RequestMapping(value = "/nidospring/game", method = RequestMethod.GET)
	public String giochicchiamo(Model model) {
		System.out.println("GET /nidospring/game");
		
		Contact contact = new Contact();
		
//		contact.setId(100);
		contact.setName("Hola");
		contact.setSurname("Hello");
		contact.setEmail("hola@halo.it");
		contact.setTelephone("123456789");
		contact.setNote("Facciamo una prova save()");
		
		Contact saved = contactRepository.save(contact);
		
		model.addAttribute("contact", contact);
		model.addAttribute("saved", saved);
		
		return "nidoviews/game";
	}

}
