package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public List<User> findByCredentials(String email, String password);
}
