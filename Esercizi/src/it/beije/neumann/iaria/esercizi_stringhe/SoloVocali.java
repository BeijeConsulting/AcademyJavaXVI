package it.beije.neumann.iaria.esercizi_stringhe;

public class SoloVocali {
	
	public static void main(String[] args) {
		String parola = "Parola";
		char[] vocali = {'a','e','i','o','u'};
		for(int i=0; i<parola.length(); i++) {
			char lettera = parola.charAt(i);
			for(int j=0; j<vocali.length; j++) {
				if(lettera == vocali[j]) {
					System.out.println(lettera);
				}
			}
		}
	}

}