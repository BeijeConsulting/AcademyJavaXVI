package it.beije.beijeJet.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class TotalFlightDTO {

	@JsonProperty(value="id_flight")
	private Integer idFlight;
	
	@JsonProperty(value="id_airport_departure")
	private Integer airportDeparture;
	
	@JsonProperty(value="id_airport_arrival")
	private Integer airportArrival;
	
	@JsonProperty(value="time_departure")
	private LocalDateTime timeDeparture;
	
	@JsonProperty(value="time_arrival")
	private LocalDateTime timeArrival;
	
	@JsonProperty(value="cost")
	private BigDecimal cost;
	
	@JsonProperty(value="max_capacity")
	private Integer maxCapacity;
	
	@JsonProperty(value="company")
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
		this.timeDeparture=timeDeparture;
	}

	public LocalDateTime getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(LocalDateTime timeArrival) {
		this.timeArrival = timeArrival;
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

	public void setMax_capacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@JsonGetter(value = "time_departure")
	public String getTimeDepartureAsString() {
		if (timeDeparture != null) return timeDeparture.toString();
		return "";
	}
	
	@JsonGetter(value = "time_arrival")
	public String getTimeArrivalAsString() {
		if (timeArrival != null) return timeArrival.toString();
		return "";
	}
	
}
