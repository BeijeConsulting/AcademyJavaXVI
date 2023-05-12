package it.beije.beijeAir.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "voli")
public class Voli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "citta_partenza", nullable = false)
	private Citta cittaPartenza;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "citta_arrivo", nullable = false)
	private Citta cittaArrivo;

	@Column(name="data_partenza")
	private LocalDateTime dataPartenza;
	
	@Column(name="data_arrivo")
	private LocalDateTime dataArrivo;
	
	@Column
	private Integer capienza;
	
	@Column
	Double prezzo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public LocalDateTime getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDateTime dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	
		
	@JsonGetter(value = "data_arrivo")
	public String getDataArrivoAsAstring() {
		return dataArrivo.toString();
	}
	
	@JsonGetter(value = "data_partenza")
	public String getDataPartenzaAsAstring() {
		return dataPartenza.toString();
	}
	
	
	@JsonIgnore
	public LocalDateTime getDataArrivo() {
		return dataArrivo;
	}
	
	public void setDataArrivo(LocalDateTime dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Citta getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(Citta cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public Citta getCittaArrivo() {
		return cittaArrivo;
	}

	public void setCittaArrivo(Citta cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}
	
}
