package it.beije.neumann.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

}

