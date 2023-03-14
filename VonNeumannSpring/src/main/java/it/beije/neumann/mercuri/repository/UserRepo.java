package it.beije.neumann.mercuri.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import it.beije.neumann.mercuri.model.MyUser;

public interface UserRepo extends JpaRepository<MyUser, Integer> {

}
