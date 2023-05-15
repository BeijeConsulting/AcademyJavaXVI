package it.beije.beijeJet.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeJet.model.Flight;


@Repository
public interface FlightRepository  extends JpaRepository<Flight, Integer>{

	
	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE f.time_departure = :timeDeparture AND "
			+ " f.id_airport_arrival = :airportArrival AND f.id_airport_departure =:airportDeparture", nativeQuery = true)
	public Flight getFlight(@Param(value="timeDeparture")LocalDateTime timeDeparture,
			@Param(value="airportArrival")Integer airportArrival,
			@Param(value="airportDeparture")Integer airportDeparture);
	
	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE (f.time_departure BETWEEN CONCAT(:timeDeparture,' 00:00:00') AND CONCAT(:timeDeparture,' 23:59:59')) AND "
			+ " f.id_airport_arrival = :airportArrival AND f.id_airport_departure =:airportDeparture", nativeQuery = true)
	public List<Flight> getFlightDate(@Param(value="timeDeparture")LocalDate timeDeparture,
			@Param(value="airportArrival")Integer airportArrival,
			@Param(value="airportDeparture")Integer airportDeparture);

}
