package it.beije.neumann.mercuri.eserciziMail8Feb;

import java.util.Iterator;

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
	
	public static boolean groupCheck(String s) {
		
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			
			System.out.print(s.charAt(i) + " ");
			System.out.println((int)s.charAt(i));
			
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				
				counter++;
				
				if (s.charAt(i + 1) != s.charAt(i) + 2 && s.charAt(i + 1) != s.charAt(i) + 1 && (s.charAt(i + 1) == ')' || s.charAt(i + 1) == ']' || s.charAt(i + 1) == '}')) {
					
					return false;
				}
			}
			else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') counter --;
							
			
		}
		if (counter == 0)
			return true;
		else 
			return false;
	}
			
//	Lo scopo di questo esercizio è convertire una stringa in una nuova stringa, dove ogni carattere della nuova stringa è ‘(‘ se il carattere corrispondente nella 
//	stringa originale è unico, altrimenti vale ‘)’. Ignorare le maiuscole/minuscole per decidere se un carattere è duplicato o meno.Per esempio:”din” => “(((“”recede” => “()()()”
//	“Success” => “)())())”
//	“(( @” => “))((“
	
	public static String convertToBraces(String s) {
		
		StringBuilder sb = new StringBuilder();
		char brace = 0;
		s = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
			
			char letter = s.charAt(i);
			
			brace = '(';
			
			for (int j = 0; j < s.length(); j++) {
				
				if (j == i) continue;
				
				if (letter == s.charAt(j)) {
					brace = ')';
					break;
				}
								
			}
			
			sb.append(brace);
		}
		return sb.toString();
	}
	
//	Scrivere la funzione “persistenza”, che prende un parametro intero positivo e ritorna la sua “persistenza moltiplicativa”, 
//	che è il numero di volte per cui bisogna moltiplicare le cifre fra loro fino ad avere un unico carattere.Per esempio:persistence(39) == 3  perché 3*9 = 27, 2*7 = 14, 1*4=4
//	 e 4 è diuna cifra solapersistence(999) == 4  perché 9*9*9 = 729, 7*2*9 = 126,
//	 1*2*6 = 12, e 1*2 = 2
//	persistence(4) == 0  perché 4 è già una cifra singola
	
	public static int persistence (int number) {
		
		int product = number;
		int loop = 0;
		
		while (product > 9) {
			
			product = 1;
			while (number != 0) {
				
				product *= number % 10;
				number /= 10;
			}

			number = product;
			
			loop++;
		} 
		
		return loop;
	}
	public static void main(String[] args) {
		
		System.out.println(persistence(23));
	}

}
