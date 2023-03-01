package it.beije.neumann.nidospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.nidospring.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public List<Contact> findBySurname(String surname);
	
	public List<Contact> findByName(String name);
	
	public List<Contact> findBySurnameAndName(String surname, String name);
	
}
