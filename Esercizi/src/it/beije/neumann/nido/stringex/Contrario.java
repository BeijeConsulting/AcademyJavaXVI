/*
 * Scrivere un programma Contrario che, data una stringa,
 * la stampa al contrario. Per esempio, la stringa
 * “Viva Java!” verrà “!avaJ aviV”
 */
package it.beije.neumann.nido.stringex;

public class Contrario {

	public static void main(String[] args) {
		
		for(String stringa:args) {
			for(int c=stringa.length()-1; c>=0;c--) {
				System.out.print(stringa.charAt(c));
			}
			System.out.println();
		}

	}

}
