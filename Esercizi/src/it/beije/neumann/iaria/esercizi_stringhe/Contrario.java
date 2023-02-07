package it.beije.neumann.iaria.esercizi_stringhe;

public class Contrario {

	public static void main(String[] args) {
		String parola = "Viva Java!";
		for(int i=parola.length()-1; i>=0; i--) {
			System.out.print(parola.charAt(i));
		}
	}

}