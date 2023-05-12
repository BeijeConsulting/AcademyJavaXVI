package it.beije.beijeJet.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReqFlightsDTO {
	LocalDate day;
	String from;
	String to;

	public LocalDate getDay() {
		return day;
	}

	public void setDay(String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate d = LocalDate.parse(day, formatter);
		this.day = d;
	}

	public void setDay(LocalDate day) {

		this.day = day;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
