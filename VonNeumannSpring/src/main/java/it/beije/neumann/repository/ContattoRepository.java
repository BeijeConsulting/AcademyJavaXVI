package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Contatto;


@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {

	public List<Contatto> findBySurname(String surname);

	public List<Contatto> findBySurnameAndName(String surname, String name);
	
	//@Query(value = "SELECT COUNT(c) FROM Contatto as c WHERE c.surname = :surname")
	@Query(value = "SELECT COUNT(c.id) FROM contatti as c WHERE c.cognome = :surname", nativeQuery = true)
	public int countBySurname(@Param("surname") String surname);
	
}
