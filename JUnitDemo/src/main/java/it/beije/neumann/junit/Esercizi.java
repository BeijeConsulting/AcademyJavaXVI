package it.beije.neumann.junit;

public class Esercizi {

	//1. Scrivi una classe JUnit per testare un metodo che verifica se una data stringa è un palindromo (cioè se può essere letta nello stesso modo da sinistra a destra e viceversa). Il test dovrebbe coprire almeno due casi di input validi e uno non valido.

	public static boolean isPalindrome (String s) {		
		
		String sRev = "";
		boolean flag = false;
		
		for(int i = s.length() - 1; i >= 0; i--) {
			sRev = sRev + s.charAt(i);
		}
		
		if(s.equals(sRev)) {
			flag = true;
		}
		
		return flag;
		
	}

	//2. Scrivi una classe JUnit per testare un metodo che verifica se un numero è primo o no. Il test dovrebbe coprire almeno due casi di input validi e uno non valido.
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
	

	//3. Scrivi una classe JUnit per testare un metodo che calcola il fattoriale di un numero intero positivo. Il test dovrebbe coprire almeno due casi di input validi e uno non valido.
	public static int factorial(int n) {

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
	
}
