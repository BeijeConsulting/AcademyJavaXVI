package it.beije.mercuri.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import it.beije.mercuri.model.Contatto;
import it.beije.mercuri.repo.FakeContacts;



@Service
public class RubricaService {
	
	
	FakeContacts contatti = new FakeContacts();
		
	public Map<String, List<Contatto>> viewContatti (){
		
		Map<String, List<Contatto>> res = new HashMap<>();
		
		res.put("contacts",contatti.viewContacts());
		return res;
	}
	

}
