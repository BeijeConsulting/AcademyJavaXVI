package it.beije.beijeAir.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voli")
public class Voli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name="citta_partenza")
	private Integer cittaPartenza;
	
	@Column(name="citta_arrivo")
	private Integer cittaArrivo;
	
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

	public Integer getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(Integer cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	public Integer getCittaArrivo() {
		return cittaArrivo;
	}

	public void setCittaArrivo(Integer cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
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
