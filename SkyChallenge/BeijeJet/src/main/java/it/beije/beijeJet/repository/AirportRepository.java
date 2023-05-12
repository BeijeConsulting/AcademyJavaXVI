package it.beije.beijeJet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.beijeJet.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer>{

}
