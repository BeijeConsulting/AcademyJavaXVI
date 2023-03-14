package it.beije.neumann.nidospring.controllerREST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.exception.ForbiddenException;
import it.beije.neumann.exception.InvalidJSONException;
import it.beije.neumann.nidospring.model.Contact;
import it.beije.neumann.nidospring.service.ContactService;

@RestController
@RequestMapping(value = "nidorest")
public class RubricaRESTController {

	@Autowired
	private ContactService contactService;

	@GetMapping(value = "/contacts")
	public List<Contact> showAllContacts(HttpServletRequest request, @RequestParam(required = false) String onWhat, @RequestParam(required = false) String orderBy) {
		System.out.println("GET "+request.getRequestURL());

		return contactService.findBySorted(onWhat, orderBy);
	}

	@GetMapping(value = "/contact/{id}")
	public Contact contactDetails(HttpServletRequest request, @PathVariable(name = "id") Integer id) {
		System.out.println("GET "+request.getRequestURL());

		return contactService.findContactById(id);

	}
	
	@GetMapping(value = "/contact")
	public List<Contact> searchContact(HttpServletRequest request, @RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
		System.out.println("GET "+request.getRequestURL());

		if (surname != null && name != null) return contactService.findContactByFullName(surname, name);
		
		if (surname != null) return contactService.findContactBySurname(surname);

		if (name != null) return contactService.findContactByName(name);
		
		return contactService.findBySorted(null, null);

	}
	
	@PostMapping(value="/contact")
	public Contact addContact(HttpServletRequest request, @RequestBody Contact data) {
		System.out.println("POST "+request.getRequestURL());
		
		System.out.println(data);
		if (data.getId()!=null) throw new InvalidJSONException("Non è possibile aggiungere un contatto con ID avvalorato");

		return contactService.saveContact(data);
	}
	
	@PutMapping(value="/contact/{id}")
	public Contact updateContact(HttpServletRequest request, @PathVariable Integer id, @RequestBody Contact edit) {
		System.out.println("PUT "+request.getRequestURL());
		
		if(id.compareTo(edit.getId()) !=0) throw new InvalidJSONException("Attenzione, gli ID inseriti non corrispondono!");
		
		contactService.updateContact(id, edit);
		
		return edit;
	}
	
	@DeleteMapping(value = "/contact/{id}")
	public Boolean deleteContact(HttpServletRequest request, @PathVariable Integer id) {
		System.out.println("DELETE "+request.getRequestURL());
		return contactService.deleteContact(id);
	}

}
