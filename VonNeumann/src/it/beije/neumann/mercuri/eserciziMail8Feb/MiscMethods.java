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
			
			exa = "";
			int n = 0;
			
			for (int j = i; j > 0; j = j/16) {
				
				n++;
				int digit = j % (int) Math.pow(16, n);
				
				switch (digit) {
					case 10: exa += "a";
					break;
					case 11: exa += "b";
					break;
					case 12: exa += "c";
					break;
					case 13: exa += "d";
					break;
					case 14: exa += "e";
					break;
					case 15: exa += "f";
					break;
					default: exa = digit + exa ;
				}
			}
			
			if (i < 16 && exa.length() == 1) exa = "0" + exa;
				
			grey = exa + exa + exa;
			
				System.out.println(grey);
		}
		
		return greys;

	}
			
	public static void main(String[] args) {
		
		shadesOfGrey(143);
	}

}
