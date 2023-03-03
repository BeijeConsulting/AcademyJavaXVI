package it.beije.neumann.iaria_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.iaria_ecommerce.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	//Metodi
}
