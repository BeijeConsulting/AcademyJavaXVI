/*
 * Scrivere un programma che chieda agli utenti due stringhe
 * in ingresso, le stringhe possono valere solo: “carta”,
 * “forbice” o “sasso”. Il programma dovrà quindi effettuare
 * i dovuti controlli e dichiarare il vincitore secondo le note
 * regole della “morra cinese” (forbice vince su carta, carta
 * vince su sasso, sasso vince su forbice).
 */
package it.beije.neumann.nido.statics;

import java.util.Scanner;

public class SassoCartaForbice {

	public static boolean check(String value) {
		return (value.equalsIgnoreCase("carta") || value.equalsIgnoreCase("forbice")
				|| value.equalsIgnoreCase("sasso"));
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String player1 = null;
		String player2 = null;

		do {
			System.out.print("Player 1 -> ");
			player1 = in.nextLine();
			System.out.println();
		} while (!check(player1));

		do {
			System.out.print("Player 2 -> ");
			player2 = in.nextLine();
			System.out.println();
		} while (!check(player2));

		StringBuilder win = new StringBuilder();

		boolean c1 = player1.equalsIgnoreCase("carta") && player2.equalsIgnoreCase("sasso");
		boolean c2 = player1.equalsIgnoreCase("forbice") && player2.equalsIgnoreCase("carta");
		boolean c3 = player1.equalsIgnoreCase("sasso") && player2.equalsIgnoreCase("forbice");
		boolean c4 = player1.equalsIgnoreCase(player2);

		if (c1 || c2 || c3) {
			win.append("Vince Player 1!");
		} else if (c4) {
			win.append("Pareggio!");
		} else {
			win.append("Vince Player 2!");
		}

		System.out.println(win.toString());
		
		in.close();

	}

}
