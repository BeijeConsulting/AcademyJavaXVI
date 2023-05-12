package it.beije.beijeAir.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voli")
public class Voli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "citta_partenza", nullable = false)
	private Citta cittaPartenza;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "citta_arrivo", nullable = false)
	private Citta cittaArrivo;
	
	public void setCittaPartenza(Citta cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public void setCittaArrivo(Citta cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}

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

	public LocalDateTime getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDateTime dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

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
	
	
}
