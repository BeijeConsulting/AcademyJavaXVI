package it.beije.beijeJet.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;


public class FlightDTO {
	
	
	@JsonProperty(value="id_airport_departure")
	private Integer airportDeparture;
	
	@JsonProperty(value="id_airport_arrival")
	private Integer airportArrival;
	
	private String timeDeparture;
	
public String getTimeDeparture() {
		
		
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	    LocalDateTime dob = LocalDateTime.parse((CharSequence)timeDeparture, formatter);
//	    this.timeDeparture = dob;
		
		this.timeDeparture = timeDeparture;
	}

	public Integer getIdAirportArrival() {
		return airportArrival;
	}

	public Integer getIdAirportDeparture() {
		return airportDeparture;
	}

	public void setIdAirportDeparture(Integer idAirportDeparture) {
		this.airportDeparture = idAirportDeparture;
	}

	public void setIdAirportArrival(Integer idAirportArrival) {
		this.airportArrival = idAirportArrival;
	}
	
}
