package it.beije.beijeAir.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.beije.beijeAir.model.Voli;

public class RouteDto {
	@JsonProperty(value = "voli")
	private List<Voli> voli;

	public List<Voli> getVoli() {
		return voli;
	}

	public void setVoli(List<Voli> voli) {
		this.voli = voli;
	}
}
