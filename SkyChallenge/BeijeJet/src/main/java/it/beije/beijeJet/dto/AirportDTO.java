package it.beije.beijeJet.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.beije.beijeJet.model.City;

public class AirportDTO {
	
	@JsonProperty(value="id_airport")
	private Integer idAirport;
	
	private String name;
	
	public AirportDTO(){
		
	}
	
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
	
}
