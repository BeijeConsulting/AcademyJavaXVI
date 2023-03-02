package it.beije.neumann.iaria_contatti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.iaria_contatti.model.IariaContatto;

@Repository
public interface IariaContattoRepository extends JpaRepository<IariaContatto, Integer> {

	public List<IariaContatto> findByCognome(String surname);
	
	public List<IariaContatto> findByCognomeAndNome(String surname, String name);
	
}
