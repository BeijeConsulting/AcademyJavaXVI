package it.beije.neumann.mercuri.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import it.beije.neumann.mercuri.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
