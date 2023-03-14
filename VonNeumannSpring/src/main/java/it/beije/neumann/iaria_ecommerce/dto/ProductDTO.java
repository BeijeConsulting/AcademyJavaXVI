package it.beije.neumann.iaria_ecommerce.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


public class ProductDTO {

	private Integer id;
	
	@JsonProperty(value = "created_at")
	private LocalDateTime creazione;
	
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getCreazione() {
		return creazione;
	}

	public void setCreazione(LocalDateTime creazione) {
		this.creazione = creazione;
	}
	
	public String getName() {
		return name;
	}

	public void setId(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(" creazione: ").append(creazione)
				.append(" nome: ").append(name)
				.append("}");

		return builder.toString();
	}

}
