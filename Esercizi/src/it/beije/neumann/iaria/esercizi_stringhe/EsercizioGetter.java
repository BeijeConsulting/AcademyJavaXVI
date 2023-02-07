package it.beije.neumann.iaria.esercizi_stringhe;

public class EsercizioGetter {
	
	private String cognome;
	
	public String getCognome(String cognome) {
		this.cognome = cognome;
		return cognome;
	}

	public static void main(String[] args) {
		EsercizioGetter eserciziogetter = new EsercizioGetter();
		eserciziogetter.getCognome("Iaria");
		System.out.println(eserciziogetter.cognome);
	}

}
