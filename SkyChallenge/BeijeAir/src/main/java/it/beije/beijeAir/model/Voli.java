package it.beije.beijeAir.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import it.beije.beijeAir.dto.RottaConIdDto;

@Entity
@NamedNativeQuery(
	    name = "find_route_one",
	    query =
	    		"SELECT v1.id AS volo1_id, v2.id AS volo2_id, 0 AS volo3_id "
	    				+ "FROM voli AS v1 "
	    				+ "JOIN voli AS v2 ON v1.citta_arrivo = v2.citta_partenza "
	    				+ "WHERE (v1.citta_partenza = :cittaPartenza OR :cittaPartenza is null) "
	    				+ "AND (v2.citta_arrivo = :cittaArrivo OR :cittaArrivo is null) "
	    				+ "AND v2.data_partenza > v1.data_arrivo "
	    				+ "AND ((v1.data_partenza BETWEEN :dataPartenza AND :dataRitorno) OR :dataPartenza is null OR :dataRitorno is null)",
	    resultSetMapping = "id_route_dto"
	)

@NamedNativeQuery(
	    name = "find_route_two",
	    query =
	    		"SELECT v1.id AS volo1_id, v2.id AS volo2_id, v3.id AS volo3_id "
	    				+ "FROM voli AS v1 "
	    				+ "JOIN voli AS v2 ON v1.citta_arrivo = v2.citta_partenza "
	    				+ "JOIN voli AS v3 ON v2.citta_arrivo = v3.citta_partenza "
	    				+ "WHERE (v1.citta_partenza = :cittaPartenza OR :cittaPartenza is null) "
	    				+ "AND (v3.citta_arrivo = :cittaArrivo OR :cittaArrivo is null) "
	    				+ "AND v2.data_partenza > v1.data_arrivo "
	    				+ "AND v3.data_partenza > v2.data_arrivo "
	    				+ "AND ((v1.data_partenza BETWEEN :dataPartenza AND :dataRitorno) OR :dataPartenza is null OR :dataRitorno is null)",
	    resultSetMapping = "id_route_dto"
	)

	@SqlResultSetMapping(
	    name = "id_route_dto",
	    classes = @ConstructorResult(
	        targetClass = RottaConIdDto.class,
	        columns = {
	            @ColumnResult(name = "volo1_id", type = Integer.class),
	            @ColumnResult(name = "volo2_id", type = Integer.class),
	            @ColumnResult(name = "volo3_id", type = Integer.class)
	        }
	    )
	)
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
	public String getDataArrivoAsString() {
		return dataArrivo.toString();
	}
	
	@JsonGetter(value = "data_partenza")
	public String getDataPartenzaAsString() {
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

	@JsonIgnore
	public Citta getCittaPartenza() {
		return cittaPartenza;
	}

	public void setCittaPartenza(Citta cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}

	@JsonIgnore
	public Citta getCittaArrivo() {
		return cittaArrivo;
	}

	public void setCittaArrivo(Citta cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}

	@Override
	public String toString() {
		return "Voli [id=" + id + ", cittaPartenza=" + cittaPartenza + ", cittaArrivo=" + cittaArrivo
				+ ", dataPartenza=" + dataPartenza + ", dataArrivo=" + dataArrivo + ", capienza=" + capienza
				+ ", prezzo=" + prezzo + "]";
	}
	
	
	
	@JsonGetter(value = "citta_partenza")
	public String getCittaPartenzaAsString() {
		return cittaPartenza.getNome() + " - " + cittaPartenza.getNazione();
	}
	
	@JsonGetter(value = "citta_arrivo")
	public String getCittaArrivoAsString() {
		return cittaArrivo.getNome() + " - " + cittaArrivo.getNazione();
	}
	
}
