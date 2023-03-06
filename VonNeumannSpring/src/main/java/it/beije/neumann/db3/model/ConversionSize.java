package it.beije.neumann.db3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "conversion_sizes")
public class ConversionSize {
    @Id
    @Column(name = "EU")
    private String eu;

    @Column(name = "USA")
    private String usa;

    @Column(name = "UK")
    private String uk;

    @Column(name = "CM")
    private String cm;

    public ConversionSize() {
    }

    public ConversionSize(String eu, String usa, String uk, String cm) {
        this.eu = eu;
        this.usa = usa;
        this.uk = uk;
        this.cm = cm;
    }

    // getters and setters
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

	@Override
	public String toString() {
		return "ConversionSizes [eu=" + eu + ", usa=" + usa + ", uk=" + uk + ", cm=" + cm + "]";
	}
    
}