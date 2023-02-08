package it.beije.neumann.vanoli._02_01;

public class Esercizio6 {
	public static void main(String[] args) {
		for (int i = 1; i <= 6; i++){
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.print("      ");
			for (int j = 6 - (i-1); j >= 1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}	
	}
}