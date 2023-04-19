package it.beije.boot.nido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.boot.nido.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
