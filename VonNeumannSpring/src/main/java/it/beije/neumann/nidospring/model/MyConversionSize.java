package it.beije.neumann.nidospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion_sizes")
public class MyConversionSize {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "EU")
	private String EU;

	@Column(name = "USA")
	private String USA;

	@Column(name = "UK")
	private String UK;

	@Column(name = "CM")
	private String CM;
	
	@Column(name = "type")
	private String type;
	
	// Getters-Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEU() {
		return EU;
	}

	public void setEU(String eU) {
		EU = eU;
	}

	public String getUSA() {
		return USA;
	}

	public void setUSA(String uSA) {
		USA = uSA;
	}

	public String getUK() {
		return UK;
	}

	public void setUK(String uK) {
		UK = uK;
	}

	public String getCM() {
		return CM;
	}

	public void setCM(String cM) {
		CM = cM;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Size Id: ").append(id).append(",<br>")
				.append(" EU: ").append(EU).append(",<br>")
				.append(" USA: ").append(USA).append(",<br>")
				.append(" UK: ").append(UK).append(",<br>")
				.append(" CM: ").append(CM).append(",<br>")
				.append(" Type: ").append(type).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", EU: ").append(EU)
				.append(", USA: ").append(USA)
				.append(", UK: ").append(UK)
				.append(", CM: ").append(CM)
				.append(", Type: ").append(type)
				.append("}");
		
		return builder.toString();
	}
	 */
}
