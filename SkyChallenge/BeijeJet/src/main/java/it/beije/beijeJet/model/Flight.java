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
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Integer idFlight;

    
    @Column(name = "id_airport_departure", nullable = false)
    private Integer airportDeparture;

    @Column(name = "id_airport_arrival", nullable = false)
    private Integer airportArrival;

    @Column(name = "time_departure")
    private LocalDateTime timeDeparture;

    @Column(name = "time_arrival")
    private LocalDateTime timeArrival;

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

	public Integer getAirportDeparture() {
		return airportDeparture;
	}

	public void setAirportDeparture(Integer airportDeparture) {
		this.airportDeparture = airportDeparture;
	}

	public Integer getAirportArrival() {
		return airportArrival;
	}

	public void setAirportArrival(Integer airportArrival) {
		this.airportArrival = airportArrival;
	}

	public LocalDateTime getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(LocalDateTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public LocalDateTime getTimeArrival() {
		return timeArrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.timeArrival = arrival;
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

	@Override
	public String toString() {
		return "Flight [id=" + idFlight + ", id_airport_departure=" + airportDeparture + ", id_airport_arrival=" + airportArrival + ", time_departure=" + timeDeparture 
				 + ", time_arrival=" + timeArrival + ", max_capacity=" + maxCapacity + ", cost=" + cost
				+ ", company=" + company +"]";
	}

    
}