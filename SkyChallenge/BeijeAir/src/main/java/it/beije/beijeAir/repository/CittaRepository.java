package it.beije.beijeAir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.beijeAir.model.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, Integer> {
	
	public Citta findByNome(String nome); 
	
}
