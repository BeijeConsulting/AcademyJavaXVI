package it.beije.beijeJet.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;


public class FlightDTO {


	
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

	@JsonProperty(value="id_airport_departure")
	private Integer idAirportDeparture;
	
	@JsonProperty(value="id_airport_arrival")
	private Integer idAirportArrival;

	public Integer getIdAirportArrival() {
		return idAirportArrival;
	}

	public Integer getIdAirportDeparture() {
		return idAirportDeparture;
	}

	public void setIdAirportDeparture(Integer idAirportDeparture) {
		this.idAirportDeparture = idAirportDeparture;
	}

	public void setIdAirportArrival(Integer idAirportArrival) {
		this.idAirportArrival = idAirportArrival;
	}
	
}
