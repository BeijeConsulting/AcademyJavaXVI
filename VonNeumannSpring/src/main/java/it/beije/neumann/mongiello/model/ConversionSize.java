package it.beije.neumann.mongiello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conversion_sizes")
public class ConversionSize {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="EU")
	private String eu;
	
	@Column(name="USA")
	private String usa;
	
	@Column(name="UK")
	private String uk;
	
	@Column(name="CM")
	private String cm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEu() {
		return eu;
	}

	public void setEu(String eu) {
		this.eu = eu;
	}

	public String getUsa() {
		return usa;
	}

	public void setUsa(String usa) {
		this.usa = usa;
	}

	public String getUk() {
		return uk;
	}

	public void setUk(String uk) {
		this.uk = uk;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}
	
	
}
