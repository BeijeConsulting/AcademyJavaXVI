package it.beije.beijeAir.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.beije.beijeAir.model.Voli;

public class RouteDto {
	@JsonProperty(value = "voli")
	private List<Voli> voli;
	
	@JsonProperty(value = "durata_volo")
	private String durataVoloCompleta;

	@JsonIgnore
	private  Duration durataVolo;
	
	@JsonIgnore
	private  Long durataVoloMinuti;
	
	public Long getDurataVoloMinuti() {
		System.out.println("sei qui long");
		return durataVoloMinuti;
	}

	public void setDurataVoloMinuti(Duration durataVolo) {
		this.durataVoloMinuti = durataVolo.toMinutes();
		 Long giorni = durataVoloMinuti / (24 * 60); 
	     Long ore = (durataVoloMinuti % (24 * 60)) / 60;
	     Long minuti = (durataVoloMinuti % 60); 
	
	     StringBuilder durataCompleta = new StringBuilder(giorni + " " + ore +" " + minuti);
	     this.setDurataVoloCompleta(durataCompleta.toString());
	}


	
	public Duration getDurataVolo() {
		return durataVolo;
	}

	public void setDurataVolo(Duration durataVolo) {
		this.durataVolo = durataVolo;
	}

	public Duration calcolaDurata( LocalDateTime andata, LocalDateTime ritorno) {
	   return Duration.between(ritorno, andata);
		
	}
	public List<Voli> getVoli() {
		return voli;
	}

	public void setVoli(List<Voli> voli) {
		this.voli = voli;
	}

	public String getDurataVoloCompleta() {
		return durataVoloCompleta;
	}

	public void setDurataVoloCompleta(String durataVoloCompleta) {
		this.durataVoloCompleta = durataVoloCompleta;
	}
	
	
	
	
	
}
