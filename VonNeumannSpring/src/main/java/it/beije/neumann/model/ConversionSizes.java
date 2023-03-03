package it.beije.neumann.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion_sizes")
public class ConversionSizes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "ConversionSizes [id=" + id + ", EU=" + EU + ", USA=" + USA + ", UK=" + UK + ", CM=" + CM + "]";
	}
	
}
