package it.beije.neumann.vanoli.feb01;

public class Esercizio8 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		for (int i = 1; i <= n; i++) {
			long a = 1;
			long b = 1;
			if (i >= 1) {
				System.out.print(a);
			}
			if (i >= 2) {
				System.out.print(", " + b);
				for (int j = 2; j < i; j++){
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