package it.beije.boot.nido.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

import it.beije.boot.nido.model.Contact;
import it.beije.boot.nido.model.FakeContact;
import it.beije.boot.nido.service.ContactService;

@RestController
@RequestMapping(value = "nido")
public class RubricaRESTController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = "/fakecontacts")
	public List<String> showAllContacts(HttpServletRequest request) {
		System.out.println("GET "+request.getRequestURL());

		return contactService.getContacts(new FakeContact("Mario", "Giuseppe", "Giovanni"));
	}
	
	@GetMapping(value = "/contacts")
	public ResponseEntity<Map<String, List<Contact>>> showContacts(HttpServletRequest request) {
		System.out.println("GET "+request.getRequestURL());
		
		Map<String, List<Contact>> res = new HashMap<>();
		res.put("contacts", contactService.findAllContacts());

		return ok(res);
	}
	
	@PostMapping(value="/add")
	public Contact addContact(HttpServletRequest request, @RequestBody Contact data) {
		System.out.println("POST "+request.getRequestURL());
		data.setId(0);
		return contactService.saveContact(data);
	}
	
	@PutMapping(value="/update/{id}")
	public Contact updateContact(HttpServletRequest request, @RequestBody Contact data, @PathVariable(name = "id") Integer id) {
		System.out.println("PUT "+request.getRequestURL());
		data.setId(id);
		return contactService.saveContact(data);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteContact(HttpServletRequest request, @PathVariable(name="id") Integer id) {
		System.out.println("DELETE "+request.getRequestURL());
		
		return contactService.deleteContact(id);
	}

}
