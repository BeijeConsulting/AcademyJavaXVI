package it.beije.beijeAir.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDto {

	@JsonProperty(value = "citta_partenza")
	private String cittaPartenza;
	
	@JsonProperty(value = "citta_arrivo")
	private String cittaArrivo;
	
	public String getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public String getCittaArrivo() {
		return cittaArrivo;
	}

	public void setCittaArrivo(String cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}
	
	
	
}
