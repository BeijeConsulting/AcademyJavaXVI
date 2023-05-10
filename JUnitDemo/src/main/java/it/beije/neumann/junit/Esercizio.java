package it.beije.neumann.junit;

public class Esercizio {
	
	/**
	 * 1. Scrivi una classe JUnit per testare un metodo che verifica se una data stringa è un palindromo 
	 * (cioè se può essere letta nello stesso modo da sinistra a destra e viceversa).
	 *  Il test dovrebbe coprire almeno due casi di input validi e uno non valido.
	 */
	public static boolean isPalindrome(String str) {
	    int length = str.length();
	    for (int i = 0; i < length / 2; i++) {
	        if (str.charAt(i) != str.charAt(length - i - 1)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	/**
	 * 2. Scrivi una classe JUnit per testare un metodo che verifica se un numero è primo o no.
	 *  Il test dovrebbe coprire almeno due casi di input validi e uno non valido.

	 */

	public static boolean isPrime(int n) {
	    if (n <= 1) {
	        return false;
	    }

	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }

	    return true;
	}

	/**
	 * 3. Scrivi una classe JUnit per testare un metodo che calcola il fattoriale di un numero intero positivo. 
	 * Il test dovrebbe coprire almeno due casi di input validi e uno non valido.
	 */
	public static int fattoriale(int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}
	
	/**
	 * 4. Scrivi una classe JUnit per testare un metodo che cerca una stringa all'interno di un'altra stringa 
	 * e restituisce la posizione della prima occorrenza.
	 *  Se la stringa cercata non viene trovata, il metodo restituisce null. 
	 *  Il test dovrebbe includere almeno un caso in cui la stringa cercata viene trovata e un caso in cui 
	 *  la stringa cercata non viene trovata.
	 */
	
	public static Integer trovaPosizione(String stringaDaCercare, String stringaDaEsaminare) {
	    int posizione = stringaDaEsaminare.indexOf(stringaDaCercare);
	    if (posizione == -1) {
	        return null; // stringa non trovata
	    } else {
	        return posizione; // posizione della prima occorrenza
	    }
	}

	
	
	
	
}
