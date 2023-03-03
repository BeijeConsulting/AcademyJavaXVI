package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Contatto;


@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {

	public List<Contatto> findByCognome(String cognome);
	
	public List<Contatto> findByCognomeAndNome(String cognome, String nome);
	
}
