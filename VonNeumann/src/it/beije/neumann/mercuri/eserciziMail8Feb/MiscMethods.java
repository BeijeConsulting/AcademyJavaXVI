package it.beije.neumann.mercuri.eserciziMail8Feb;

public class MiscMethods {

	
	public static int getDaysTilExpired(double content, double evapPerDay , double threshold ) {
		
		int days = 0;
		//double initialContent = content;
		double currentPerc = 1;
		
		while (currentPerc * 100 >= threshold) {
			days++;
			currentPerc = currentPerc * (1 - evapPerDay / 100);
			System.out.println(currentPerc);
		}  
		
		return --days;
	}
	
	public static int rowSumOddNumbers(int n) {
		
		int sum = 0;
		
		int firstOdd = n * (n - 1) + 1;
		
		for (int j = 0; j < n; j++) {
			
			sum += firstOdd;
			firstOdd += 2;
			
		}
		return sum;
	}
	
	public static void caffeina(int n) {
		
		switch (n%12) {
		default: System.out.print("match_missed!");	
		break;
		case 3: case 9: System.out.print("Java");	
		break;
		case 6: System.out.print("JavaScript");
		break;
		case 0: System.out.print("CoffeScript");
				
		
		}
	}
	
//	Scrivere una funzione che prende un numero intero n come parametro e
//	ritorna un array di sfumature di grigio in codice esadecimale (#aaaaaa, per esempio).
//	L’array dovrebbe essere ordinato in senso ascendente (#010101, #020202, ecc), usando le lettere minuscole.public class ShadesOfGrey {
//
//	Ricorda che: il grigio è un colore composto dalla stessa quantità di rosso, verde e blu:
//			#010101, #aeaeae, #555555. Inoltre: #000000 e #FFFFFF non sono valori accettati.Se n è negativo ritornare un array vuoto,
//			se n è maggiore di 254, ritornare un array di 254 elementi.
			
	static String[] shadesOfGrey(int num) {
		
		num = num > 254? 254 : num;
		String[] greys = null;		
		String exa = null;		
		String grey = null;

		for (int i = 0; i < num; i++) {
			
			for (int j = i; j > 0; j= j/10) {
				switch (j % 16) {
				//case 10: exa += 
				}
			}
			grey = exa + exa + exa;
			System.out.println(grey);
		}
		
		return greys;

	}
			
	public static void main(String[] args) {
		
		shadesOfGrey(19);
	}

}
