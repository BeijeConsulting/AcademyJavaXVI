package it.beije.beijeJet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeJet.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer>{

	@Query(value = "SELECT name FROM beijejet.Airport as a WHERE id_airport=:id", nativeQuery = true)
	public String findNameByIdAirport(@Param("id")Integer id);
}
