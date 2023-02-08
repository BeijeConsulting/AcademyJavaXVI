/*
 * Scrivere un programma Concatena che chiede
 * all’utente di inserire tre singole parole e
 * le ristampa interponendovi un asterisco.
 * Per esempio, se l’utente inserisce “gatto”,
 * “cane” e “topo” il programma stamperà “gatto*cane*topo”.
 */
package it.beije.neumann.nido.stringex;

import java.util.Scanner;

public class Concatena {

	public static String conArgs(String[] args) {
		StringBuilder strConc = new StringBuilder();

		for (String parola : args) {
			strConc.append(parola + " ");
		}
		String finalStr = strConc.toString();
		finalStr = finalStr.trim().replace(' ', '*');

		return finalStr;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Parola 1 -> ");
		String s1 = in.nextLine();
		System.out.print("Parola 2 -> ");
		String s2 = in.nextLine();
		System.out.print("Parola 3 -> ");
		String s3 = in.nextLine();
		
		System.out.println("Stringa elaborata -> "+s1+"*"+s2+"*"+s3);
		//System.out.println("Stringa elaborata -> "+conArgs(args));
		
		in.close();

	}

}
