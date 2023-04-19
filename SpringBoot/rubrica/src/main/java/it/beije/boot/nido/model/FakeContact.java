package it.beije.boot.nido.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeContact {
	public List<String> contacts = new ArrayList<>();
	
	public FakeContact(String...names){
		this.contacts = Arrays.asList(names);
	}

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}
}
