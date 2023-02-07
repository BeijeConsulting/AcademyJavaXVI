package it.beije.neumann.vanoli.feb01;

public class Esercizio7 {
	public static void main(String[] args) {
		long a = 1;
		long b = 1;
		System.out.println(a);
		System.out.println(b);
		for (int i = 2; i < 100; i++){
			long c = a + b;
			a = b;
			b = c;
			System.out.println(Long.toUnsignedString(c));
		}	
	}
}