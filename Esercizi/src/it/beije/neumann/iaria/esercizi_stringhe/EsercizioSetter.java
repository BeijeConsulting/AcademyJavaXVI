package it.beije.neumann.iaria.esercizi_stringhe;

public class EsercizioSetter {
	
	private String cognome;
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public static void main(String[] args) {
		EsercizioSetter eserciziosetter = new EsercizioSetter();
		eserciziosetter.setCognome("Iaria");
		System.out.println(eserciziosetter.cognome);
	}

}
