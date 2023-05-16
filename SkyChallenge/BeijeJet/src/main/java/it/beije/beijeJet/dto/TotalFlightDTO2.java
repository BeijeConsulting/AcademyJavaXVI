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

public class TotalFlightDTO2 extends TotalFlightDTO{

	TotalFlightDTO2 chain = null;
	private Integer airportDepartureId;
	private Integer airportArrivalId;
	
	public TotalFlightDTO2 getChain() {
		return chain;
	}

	public void setChain(TotalFlightDTO2 chain) {
		this.chain = chain;
	}

	public Integer getAirportDepartureId() {
		return airportDepartureId;
	}

	public void setAirportDepartureId(Integer airportDepartureId) {
		this.airportDepartureId = airportDepartureId;
	}

	public Integer getAirportArrivalId() {
		return airportArrivalId;
	}

	public void setAirportArrivalId(Integer airportArrivalId) {
		this.airportArrivalId = airportArrivalId;
	}

	@Override
	public String toString() {
		return "TotalFlightDTO2 [chain=" + chain + ", airportDepartureId=" + airportDepartureId + ", airportArrivalId="
				+ airportArrivalId + "]";
	}

	
}
