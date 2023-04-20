package it.beije.boot.rubrica.service.nicole;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.boot.rubrica.repository.nicole.FakeContactRepository;
import it.beije.boot.rubrica.model.nicole.Contact;


@Service
public class ContactService {
	
	
	
	
	public List<Map<String, Object>> getContactByName(String name) {
		
		Map<String,Object> map= null;
		List<Map<String, Object>> list=new ArrayList<>();
		
		List<Contact> contatti=FakeContactRepository.findContactsByName(name);
		
		for(Contact c: contatti) {
			map=new LinkedHashMap<>();
			map.put("Name", c.getName());
			map.put("Surname", c.getSurname());
			map.put("Email", c.getEmail());
			map.put("Phone Number", c.getPhoneNumber());
			list.add(map);
		
	
		}
		
		return list;
	}
	
public List<Map<String, Object>> getAllContacts() {
		
		Map<String,Object> map= null;
		List<Map<String, Object>> list=new ArrayList<>();
		
		List<Contact> contatti=FakeContactRepository.findAllContacts();
		
		for(Contact c: contatti) {
			map=new LinkedHashMap<>();
			map.put("Name", c.getName());
			map.put("Surname", c.getSurname());
			map.put("Email", c.getEmail());
			map.put("Phone Number", c.getPhoneNumber());
			list.add(map);
		
	
		}
		
		return list;
	}
	

}
