package it.beije.beijeAir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.beijeAir.model.Voli;

@Repository
public interface VoliRepository extends JpaRepository<Voli, Integer> {
	
	

}
