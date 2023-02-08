/*
 * Scrivere un programma SoloVocali che, data una stringa,
 * ne stampa le sole vocali
 */
package it.beije.neumann.nido.stringex;

public class SoloVocali {

	public static void main(String[] args) {
		
		for(String stringa:args) {
		for(int c=0; c<stringa.length(); c++) {
			if ((stringa.charAt(c)=='a') || (stringa.charAt(c)=='e') || (stringa.charAt(c)=='i') || (stringa.charAt(c)=='o') || (stringa.charAt(c)=='u')) {
				System.out.println(stringa.charAt(c));
			}
		}
		}

	}

}