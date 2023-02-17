package it.beije.neumann.iaria.esercizi_stringhe;

import java.util.Scanner;

public class Concatena {

	public static void main(String[] args) {
		System.out.println("Inserisci 3 parole:");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci la prima parola:");
		String parola1 = scanner.nextLine();
		
		System.out.println("Inserisci la seconda parola:");
		String parola2 = scanner.nextLine();
		
		System.out.println("Inserisci la terza parola:");
		String parola3 = scanner.nextLine();
		
		System.out.println(parola1 + "*" + parola2 + "*" + parola3);
			
	}

}

