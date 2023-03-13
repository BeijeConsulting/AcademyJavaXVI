package it.beije.neumann.nidospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.nidospring.model.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer>{

	public MyUser findByEmailAndPassword(String email, String password);
}
