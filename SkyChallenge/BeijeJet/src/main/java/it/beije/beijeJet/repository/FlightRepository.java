package it.beije.beijeJet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.beijeJet.model.Flight;

@Repository
public interface FlightRepository  extends JpaRepository<Flight, Integer>{

}
