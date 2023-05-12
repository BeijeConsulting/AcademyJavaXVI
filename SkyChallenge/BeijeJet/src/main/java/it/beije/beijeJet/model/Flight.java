package it.beije.beijeJet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Integer idFlight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport_departure", nullable = false)
    private Airport airportDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport_arrival", nullable = false)
    private Airport airportArrival;

    @Column(name = "time_departure")
    private LocalDateTime timeDeparture;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "max_capacity")
    private Integer maxCapacity;

    @Column(name = "company")
    private String company;
    
    public Integer getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}

	public Airport getAirportDeparture() {
		return airportDeparture;
	}

	public void setAirportDeparture(Airport airportDeparture) {
		this.airportDeparture = airportDeparture;
	}

	public Airport getAirportArrival() {
		return airportArrival;
	}

	public void setAirportArrival(Airport airportArrival) {
		this.airportArrival = airportArrival;
	}

	public LocalDateTime getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(LocalDateTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	

    
}