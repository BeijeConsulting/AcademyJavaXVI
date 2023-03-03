package it.beije.neumann.elassl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion_sizes")
public class ConversionSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EU")
    private String eu;

    @Column(name = "USA")
    private String usa;

    @Column(name = "UK")
    private String uk;

    @Column(name = "CM")
    private String cm;

    private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ConversionSize [id=" + id + ", eu=" + eu + ", usa=" + usa + ", uk=" + uk + ", cm=" + cm + ", type="
				+ type + "]";
	}

    
}

