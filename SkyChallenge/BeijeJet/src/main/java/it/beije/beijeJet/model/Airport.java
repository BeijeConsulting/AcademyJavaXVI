package it.beije.beijeJet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private Integer idAirport;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @OneToMany(mappedBy = "airportDeparture", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Flight> flightsDeparture;

    @OneToMany(mappedBy = "airportArrival", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Flight> flightsArrival;

	public Integer getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(Integer idAirport) {
		this.idAirport = idAirport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Flight> getFlightsDeparture() {
		return flightsDeparture;
	}

	public void setFlightsDeparture(List<Flight> flightsDeparture) {
		this.flightsDeparture = flightsDeparture;
	}

	public List<Flight> getFlightsArrival() {
		return flightsArrival;
	}

	public void setFlightsArrival(List<Flight> flightsArrival) {
		this.flightsArrival = flightsArrival;
	}

	@Override
	public String toString() {
		return "Flight [id_airport=" + idAirport + ", name=" + name + ", id_city=" + city + ", flights_departure=" + flightsDeparture 
				 + ", flights_arrival=" + flightsArrival + ", max_capacity="+"]";
	}

    
}