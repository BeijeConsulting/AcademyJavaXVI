package it.beije.neumann.db3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.UserD;

@Repository
public interface UserRepositoryD extends JpaRepository<UserD, Integer>{

	public UserD findByEmailAndPassword(String email, String password);
	
	public UserD findByEmail(String email);
}
