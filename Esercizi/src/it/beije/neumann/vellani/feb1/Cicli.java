package it.beije.neumann.vellani.feb1;

public class Cicli {

	public static void main(String[] args) {
		
		Cicli.stampaPrimiDieciNumeri();
		System.out.println();
		Cicli.stampaPrimiDieciPari();
		System.out.println();
		Cicli.stampaTabellinaNumero(5);
		Cicli.stampaAsterischi();
		Cicli.stampaCancelletto();
		Cicli.StampaNumeriSequenza();
		Cicli.StampaFibonacci100();
		Cicli.StampaFibonacciNum(5);




	}
	

//	Scrivere un programma che stampi a video i primi dieci numeri interi
	public static void stampaPrimiDieciNumeri() {
		for(int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
	}
	

//	Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.
	public static void stampaPrimiDieciPari() {
		for(int i = 20; i > 0; i--) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	

//	Scrivere un programma che stampi le tabellina del numero dato come argomento
	public static void stampaTabellinaNumero(int n) {
		for(int i = 1; i <= 10; i++) {
			System.out.println(n + " x " + i + " = " + n * i);
		}
	}
	

//	Stampare a video la seguente figura:
//	******
//	*****
//	****
//	***
//	**
//	*
	
	public static void stampaAsterischi() {
		for(int i = 6; i > 0; i--) {
			for(int j = i; j > 0; j--) {

				System.out.print("* ");	
			}
			System.out.print("\n");
		}
		
	}
	
//	Stampare a video la seguente figura:
//	#
//	##
//	###
//	####
//	#####
//	######
	public static void stampaCancelletto() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < i; j++) {

				System.out.print("# ");	
			}
			System.out.print("\n");
		}
	}
	
//	Stampare a video la seguente figura:
//	1      654321
//	12      54321
//	123      4321
//	1234      321
//	12345      21
//	123456      1
	
	public static void StampaNumeriSequenza() {
		for (int i = 1; i <= 6; i++) {
		    for (int j = 1; j <= i; j++) {
		        System.out.print(j);
		    }

		    System.out.print("      ");
		    
		    for (int z = 6-i + 1; z >= 1; z--) {
		        System.out.print(z);
		    }
		    System.out.println();
		}
	}
	

//	Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.
	public static void StampaFibonacci100() {
		int[] fibonacci = new int[100];
		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int i = 2; i < 100; i++) {
		    fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}

		for (int i = 0; i < 100; i++) {
		    System.out.print(fibonacci[i] + " ");
		}
		System.out.println();
	}
	
//	Scrivere un programma che stampi le n righe della successione di Fibonacci in questo modo:
//		1
//		1, 1
//		1, 1, 2
//		1, 1, 2, 3
//		1, 1, 2, 3, 5
//		1, 1, 2, 3, 5, 8
//		1, 1, 2, 3, 5, 8, 13
	
	public static void StampaFibonacciNum(int n) {
		int[] fibonacci = new int[n];

		for (int i = 0; i < n; i++) {
		    fibonacci[i] = (i <= 1) ? 1 : fibonacci[i-1] + fibonacci[i-2];
		    for (int j = 0; j <= i; j++) {
		        System.out.print(fibonacci[j] + " ");
		    }
		    System.out.println();
		}
	}
	
}
