/*
 * Scrivere un programma StampaMaiuscole che,
 * dato un array di stringhe, ne stampa solo
 * quelle con la prima lettera maiuscola
 */
package it.beije.neumann.nido.string;

public class StampaMaiuscole {

	public static void main(String[] args) {
		
		for(String s:args) {
			if(s.charAt(0)>='A' && s.charAt(0)<='Z') {
				System.out.println(s);
			}
		}
		
	}

}
