package it.beije.beijeAir.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDto {

	@JsonProperty(value = "citta_partenza")
	private String cittaPartenza;

	@JsonProperty(value = "citta_arrivo")
	private String cittaArrivo;

	@JsonProperty(value = "data_partenza")
	private LocalDateTime dataPartenza;
	
	@JsonProperty(value = "andata_ritorno")
	private Boolean andataRitorno;
	
	@JsonProperty(value = "data_ritorno")
	private LocalDateTime dataRitorno;
	
	private List<String> scali;

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

	public LocalDateTime getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDateTime dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	
	@JsonGetter(value = "data_partenza")
	public String getDataPartenzaAsString() {
		if (dataPartenza != null) return dataPartenza.toLocalDate().toString();
		return "";
	}
	
	public LocalDateTime getDataRitorno() {
		return dataRitorno;
	}

	public void setDataRitorno(LocalDateTime dataRitorno) {
		this.dataRitorno = dataRitorno;
	}

	@JsonGetter(value = "data_ritorno")
	public String getDataRitonoAsString() {
		if (dataRitorno != null) return dataRitorno.toLocalDate().toString();
		return "";
	}

	public boolean isAndataRitorno() {
		return andataRitorno;
	}

	public void setAndataRitorno(boolean andataRitorno) {
		this.andataRitorno = andataRitorno;
	}

	public List<String> getScali() {
		return scali;
	}

	public void setScali(List<String> scali) {
		this.scali = scali;
	}

}
