package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public List<User> findByEmailAndPassword(String email, String password);
	
	public List<User> findByEmail(String email);
	
	
	
}
