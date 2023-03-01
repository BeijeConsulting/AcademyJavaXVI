package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Contatto;


@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {

	public List<Contatto> findBySurname(String surname);
	
	public List<Contatto> findByName(String name);
	
	public List<Contatto> findBySurnameAndName(String surname, String name);
	
}
