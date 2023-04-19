package it.beije.boot.nido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.boot.nido.model.Contact;
import it.beije.boot.nido.model.FakeContact;
import it.beije.boot.nido.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	
	public List<String> getContacts(FakeContact c){
		return c.getContacts();
	}
	
	public List<Contact> findAllContacts(){
		return contactRepo.findAll();
	}
	
	public Contact saveContact(Contact c) {
		return contactRepo.save(c);
	}
	
	public String deleteContact(Integer id) {
		Optional<Contact> c = contactRepo.findById(id);
		
		if (!c.isPresent()) return "No such element with ID: "+id;
		
		contactRepo.deleteById(id);
		
		return ("DELETED SUCCESSFULLY: " + id);
	}

}
