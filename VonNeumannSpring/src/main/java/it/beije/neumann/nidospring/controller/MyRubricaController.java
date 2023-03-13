package it.beije.neumann.nidospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.nidospring.model.Contact;
import it.beije.neumann.nidospring.repository.ContactRepository;

@Controller
public class MyRubricaController {

	@Autowired
	private ContactRepository contactRepository;
	
	@RequestMapping(value = "/nidospring/menu", method = RequestMethod.GET)
	public String viewMenu() {
		System.out.println("GET /menu");
		return "nidoviews/rubrica/menu";
	}
	
	@RequestMapping(value = "/nidospring/menu", method = RequestMethod.POST)
	public String redirectMenu(Model model, @RequestParam(required = false) String operation) {
		System.out.println("POST /menu");
		
		String redirect = "nidoviews/rubrica/menu";
		
		if(operation!=null) {
			switch(operation) {
			case "1":
				redirect = "nidoviews/rubrica/order_by_what";
				break;
			case "2":
				redirect = "nidoviews/rubrica/search_by";
				break;
			case "3":
				redirect = "nidoviews/rubrica/add_contact";
				break;
			case "4":
				redirect = "nidoviews/rubrica/menu";
				model.addAttribute("message", "Not implemented yet");
				break;
			case "5":
				redirect = "nidoviews/rubrica/menu";
				model.addAttribute("message", "Not implemented yet");
				break;
			case "6":
				redirect = "nidoviews/rubrica/menu";
				model.addAttribute("message", "Not implemented yet");
				break;
			case "7":
				redirect = "nidoviews/rubrica/menu";
				model.addAttribute("message", "Not implemented yet");
				break;
			}
		}
		
		return redirect;
	}
	
	@RequestMapping(value = "/nidospring/order_by_what", method = RequestMethod.GET)
	public String showSettings() {
		System.out.println("GET /order_by_what");
		return "nidoviews/rubrica/order_by_what";
	}

	@RequestMapping(value = "/nidospring/show_contacts", method = RequestMethod.GET)
	public String showRubrica(Model model, @RequestParam(required = false) String onWhat, @RequestParam(required = false) String orderBy) {
		System.out.println("GET /show_contacts");
		
		List<Contact> rubrica;
		
		//Ridondante, da sistemare
		if(onWhat != null) {
			String column = null;
			
			switch (onWhat) {
			case "nome":
				column = "name";
				break;
			case "cognome":
				column = "surname";
				break;
			default:
				column = "id";
				break;
			}
			
			if(orderBy!= null) {
				switch (orderBy) {
				default:
				case "asc":
					rubrica = contactRepository.findAll(Sort.by(column).ascending());
					break;
				case "desc":
					rubrica = contactRepository.findAll(Sort.by(column).descending());
					break;
				}
			} else {
				rubrica = contactRepository.findAll(Sort.by("id").ascending());
			}
			
		} else { //se non è specificato, mostrala senza impostazioni specifiche
			rubrica = contactRepository.findAll(Sort.by("id").ascending());
		}
						
		model.addAttribute("rubrica", rubrica);
		
		return "nidoviews/rubrica/show_contacts";
	}	
	
	@RequestMapping(value = "/nidospring/add_contact", method = RequestMethod.GET)
	public String addContact() {
		System.out.println("GET /add_contact");
		return "nidoviews/rubrica/add_contact";
	}
	
	@RequestMapping(value = "/nidospring/add_contact", method = RequestMethod.POST)
	public String addContact(Model model, Contact contact) {
		System.out.println("POST /add_contact");
		
		model.addAttribute("contactToAdd", contact);
		
		return "nidoviews/rubrica/add_contact";
	}
	
	@RequestMapping(value = "/nidospring/save_contact", method = RequestMethod.POST)
	public String saveContact(Model model, Contact contact) {
		System.out.println("POST /save_contact");
		
		model.addAttribute("savedContact", contactRepository.save(contact));
		
		return "nidoviews/rubrica/review_contact";
	}
	
	@RequestMapping(value = "/nidospring/search_contact", method = RequestMethod.GET)
	public String searchContact() {
		System.out.println("GET /search_contact");
		return "nidoviews/rubrica/search_by";
	}
	
	@RequestMapping(value = "/nidospring/search_contact", method = RequestMethod.POST)
	public String searchContact(Model model, @RequestParam(required=false) String name, @RequestParam(required = false) String surname) {
		System.out.println("POST /search_contact");
		List<Contact> searchResults;
		
		if (surname != null && name != null) {
			searchResults = contactRepository.findBySurnameAndName(surname, name);
		} else if (surname != null) {
			searchResults = contactRepository.findBySurname(surname);
		} else if (name != null) {
			searchResults = contactRepository.findByName(name);
		} else {
			searchResults = contactRepository.findAll();
		}
		
		model.addAttribute("rubrica", searchResults);
		
		return "nidoviews/rubrica/show_contacts";
	}
}
