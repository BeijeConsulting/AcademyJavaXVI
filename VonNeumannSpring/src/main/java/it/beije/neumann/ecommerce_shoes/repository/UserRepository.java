package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByCredentials(String email, String password);
	
	/*
	//@Query(value = "SELECT COUNT(c) FROM Contatto as c WHERE c.surname = :surname")
	@Query(value = "SELECT COUNT(c.id) FROM contatti as c WHERE c.cognome = :surname", nativeQuery = true)
	public int countBySurname(@Param("surname") String surname);
	*/
}
