package it.beije.beijeJet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_city")
	    private Integer idCity;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "country")
	    private String country;

	    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	    private List<Airport> airports;

		public Integer getIdCity() {
			return idCity;
		}

		public void setIdCity(Integer idCity) {
			this.idCity = idCity;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public List<Airport> getAirports() {
			return airports;
		}

		public void setAirports(List<Airport> airports) {
			this.airports = airports;
		}
}
