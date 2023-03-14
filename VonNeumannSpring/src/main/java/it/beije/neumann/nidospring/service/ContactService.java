package it.beije.neumann.nidospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.beije.neumann.exception.IdNotFoundException;
import it.beije.neumann.nidospring.model.Contact;
import it.beije.neumann.nidospring.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	public List<Contact> findContactByName(String name){
		return contactRepo.findByName(name);
	}
	
	public List<Contact> findContactBySurname(String surname){
		return contactRepo.findBySurname(surname);
	}
	
	public List<Contact> findContactByFullName(String surname, String name){
		return contactRepo.findBySurnameAndName(surname, name);
	}
	
	public List<Contact> findBySorted(String onWhat, String orderBy){
		List<Contact> contacts;
		
		//onWhat può essere name, surname, null = id
		if (onWhat == null) onWhat = "id";
		
		//orderBy può essere asc, desc, null = asc
		if (orderBy == null) orderBy = "asc";
		
		switch (orderBy) {
		default:
		case "asc":
			contacts = contactRepo.findAll(Sort.by(onWhat).ascending());
			break;
		case "desc":
			contacts = contactRepo.findAll(Sort.by(onWhat).descending());
			break;
		}
		
		return contacts;
	}
	
	public Contact findContactById(Integer id) {
		Optional<Contact> c = contactRepo.findById(id);
		
		if (!c.isPresent()) throw new IdNotFoundException("Nessun contatto con ID inserito...");
		
		return c.get();
	}
	
	public Contact saveContact(Contact toSave) {
		return contactRepo.save(toSave);
	}
	
	public Contact updateContact(Integer id, Contact data) {
		
		Contact toSave = findContactById(id);
		
		BeanUtils.copyProperties(data, toSave, "id");
		
		return saveContact(toSave);
		
	}
	
	public Boolean deleteContact(Integer id) {
		Optional<Contact> c = contactRepo.findById(id);
		
		if (!c.isPresent()) throw new IdNotFoundException("Nessun contatto con ID inserito...");
		
		contactRepo.deleteById(id);
		
		return true;
	}
}
