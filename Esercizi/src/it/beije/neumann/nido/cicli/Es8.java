/*
 * Scrivere un programma che stampi le n righe
 * della successione di Fibonacci in questo modo:
 * 1
 * 1, 1
 * 1, 1, 2
 * 1, 1, 2, 3
 * 1, 1, 2, 3, 5
 * 1, 1, 2, 3, 5, 8
 * 1, 1, 2, 3, 5, 8, 13
 * ....
 */
package it.beije.neumann.nido.cicli;

public class Es8 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		for (int i = 0; i < n; i++) {

			long a = 1L;
			long b = 1L;

			if (i > 0) {
				System.out.print(a);
			}

			if (i > 1) {
				System.out.print(", " + b);
				for (int j = 2; j < i; j++) {
					long c = a + b;
					a = b;
					b = c;
					System.out.print(", " + c);
				}
			}
			System.out.println();
		}
	}

}
