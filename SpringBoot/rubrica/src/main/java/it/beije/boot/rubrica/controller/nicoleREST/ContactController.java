package it.beije.boot.rubrica.controller.nicoleREST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.beije.boot.rubrica.service.nicole.ContactService;

@RestController
@RequestMapping(value="contacts")
public class ContactController 
{
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact_by_name")
	public List<Map<String, Object>> getContactByName(@RequestParam String name) {
		
		return contactService.getContactByName(name);
		
		
		
	}
	
	@GetMapping("/get_all_contacts")
	public List<Map<String, Object>> getAllContacts() {
		
		return contactService.getAllContacts();
		
		
		
	}

}
