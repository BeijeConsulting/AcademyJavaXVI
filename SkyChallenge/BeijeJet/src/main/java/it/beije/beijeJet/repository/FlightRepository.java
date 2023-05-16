package it.beije.beijeJet.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.beijeJet.model.Airport;
import it.beije.beijeJet.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE f.time_departure = :timeDeparture AND "
			+ " f.id_airport_arrival = :airportArrival AND f.id_airport_departure =:airportDeparture", nativeQuery = true)
	public Flight getFlight(@Param(value = "timeDeparture") LocalDateTime timeDeparture,
			@Param(value = "airportArrival") Integer airportArrival,
			@Param(value = "airportDeparture") Integer airportDeparture);

	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE (f.time_departure BETWEEN CONCAT(:timeDeparture,' 00:00:00') AND CONCAT(:timeDeparture,' 23:59:59')) AND "
			+ " f.id_airport_arrival = :airportArrival AND f.id_airport_departure =:airportDeparture", nativeQuery = true)
	public List<Flight> getFlightDate(@Param(value = "timeDeparture") LocalDate timeDeparture,
			@Param(value = "airportArrival") Integer airportArrival,
			@Param(value = "airportDeparture") Integer airportDeparture);

	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE (f.time_departure BETWEEN CONCAT(:timeDeparture,' 00:00:00') AND CONCAT(:timeDeparture,' 23:59:59')) AND "
			+ "f.id_airport_departure =:airportDeparture", nativeQuery = true)
	public List<Flight> getFlights(@Param(value = "timeDeparture") LocalDate timeDeparture,
			@Param(value = "airportDeparture") Integer airportDeparture);

	@Query(value = "SELECT * FROM beijejet.Flight as f WHERE (f.time_departure BETWEEN CONCAT(:timeDeparture,' 00:00:00') AND CONCAT(:timeDeparture,' 23:59:59')) AND "
			+ "f.id_airport_departure =:airportDeparture", nativeQuery = true)

	public List<Flight> getDirectFlights(@Param("airportFrom") String airportFrom,
			@Param("airportDepartureId") Integer airportDepartureId,
			@Param("airportArrivalId") Integer airportArrivalId, @Param("date") LocalDate date,
			@Param("direct") Boolean direct, @Param("oneStop") Boolean oneStop, @Param("twoStops") Boolean twoStops);

	@Query(value = "SELECT f " + "FROM Flight f " + "WHERE f.airportDeparture.name = :airportFrom "
			+ "AND f.airportDeparture.id = :airportDepartureId " + "AND f.airportArrival.id = :airportArrivalId "
			+ "AND f.timeDeparture >= :date " + "AND (:direct OR :oneStop OR :twoStops) "
			+ "ORDER BY f.timeDeparture", nativeQuery = true)

	public List<Flight> getUnoScaloFlights(@Param(value = "airportFrom") String airportFrom,
			@Param(value = "airportDepartureId") Integer airportDepartureId,
			@Param(value = "airportArrivalId") Integer airportArrivalId, @Param(value = "date") LocalDate date);

	@Query("SELECT f1 FROM Flight f1, Flight f2 " + "WHERE f1.airportDeparture = :departureId "
			+ "AND f1.airportArrival = f2.airportDeparture " + "AND f2.airportArrival = :arrivalId "
			+ "AND f1.timeDeparture >= :startDateTime " + "AND f1.timeDeparture <= :endDateTime "
			+ "AND f2.timeDeparture >= f1.timeArrival " + "AND f2.timeDeparture <= :endDateTime")
	List<Flight> findFlightsWithOneScalo(@Param("departureId") Integer departureId,
			@Param("arrivalId") Integer arrivalId, @Param("startDateTime") LocalDateTime startDateTime,
			@Param("endDateTime") LocalDateTime endDateTime);

	@Query("SELECT f1 FROM Flight f1, Flight f2, Flight f3 " + "WHERE f1.airportDeparture = :departureId "
			+ "AND f1.airportArrival = f2.airportDeparture " + "AND f2.airportArrival = f3.airportDeparture "
			+ "AND f3.airportArrival = :arrivalId " + "AND f1.timeDeparture >= :startDateTime "
			+ "AND f1.timeDeparture <= :endDateTime " + "AND f2.timeDeparture >= f1.timeArrival "
			+ "AND f2.timeArrival <= f3.timeDeparture " + "AND f3.timeDeparture <= :endDateTime")
	List<Flight> findFlightsWithTwoScali(@Param("departureId") Integer departureId,
			@Param("arrivalId") Integer arrivalId, @Param("startDateTime") LocalDateTime startDateTime,
			@Param("endDateTime") LocalDateTime endDateTime);

	List<Flight> findByAirportDepartureAndAirportArrivalAndTimeDepartureBetween(Airport airportDeparture,
			Airport airportArrival, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
