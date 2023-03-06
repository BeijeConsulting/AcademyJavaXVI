package it.beije.neumann.ecommerce_shoes.model;



	import java.time.LocalDateTime;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "conversion_sizes")
	public class ConvertionSize {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "EU")
		private String EU;
		
		@Column(name = "USA")
		private String USA;

		@Column(name = "UK")
		private String UK;

		@Column(name = "CM")
		private String CM;

		
		

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


		public String toString() {
			StringBuilder builder = new StringBuilder("{")
					.append(", EU: ").append(EU)
					.append(", USA: ").append(USA)
					.append(", UK: ").append(UK)
					.append(", CM: ").append(CM)
					
					.append("}");

			return builder.toString();
		}
		
	}


