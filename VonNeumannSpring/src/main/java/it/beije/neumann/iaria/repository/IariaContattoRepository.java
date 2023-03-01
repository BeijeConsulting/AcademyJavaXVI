package it.beije.neumann.iaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.iaria.model.IariaContatto;

@Repository
public interface IariaContattoRepository extends JpaRepository<IariaContatto, Integer> {

	public List<IariaContatto> findByCognome(String surname);
	
	public List<IariaContatto> findByCognomeAndNome(String surname, String name);
	
}
