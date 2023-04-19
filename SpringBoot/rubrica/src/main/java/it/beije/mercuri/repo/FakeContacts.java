package it.beije.mercuri.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import it.beije.mercuri.model.Contatto;

public class FakeContacts {
	
	public static String[] nameArray = {"Mario", "Carlo", "Piero"};
	
	private static List<Contatto> contacts = new ArrayList<Contatto>();
	
	static {
		Contatto c1 = new Contatto("Mario", "Rossi", "m.rossi@beije.it", "3451111111");
		Contatto c2 = new Contatto("Carlo", "Bianchi", "c.bianchi@beije.it", "3452222222");
		Contatto c3 = new Contatto("Piero", "Verdi", "p.verdi@beije.it", "3453333333");
		Contatto c4 = new Contatto("Piero", "Brambilla", "p.brambilla@beije.it", "3494444444");
		
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
	}
	
	public List<Contatto> findContactsByName(String name) {
		List<Contatto> ContactsByName = new ArrayList<Contatto>();
		
		for (Contatto c : contacts) {
			if (c.getName().equalsIgnoreCase(name)) {
				ContactsByName.add(c);
			}
		}
		
		return ContactsByName;
	}

	public List<Contatto> viewContacts() {

		
		return contacts;
	}
}
