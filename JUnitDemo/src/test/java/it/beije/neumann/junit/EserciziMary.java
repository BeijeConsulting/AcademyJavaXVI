package it.beije.neumann.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EserciziMary {

	// 1. Scrivi una classe JUnit per testare un metodo che verifica se una data
	// stringa è un palindromo (cioè se può essere letta nello stesso modo da
	// sinistra a destra e viceversa). Il test dovrebbe coprire almeno due casi di
	// input validi e uno non valido.

	//@Disabled
	@Test
	public void palindromeOne() {
		assertTrue(EserciziUtils.isPalindrome("anna"));
	}

	//@Disabled
	@Test
	public void palindromeTwo() {
		assertTrue(EserciziUtils.isPalindrome("lavava"));
	}

	//@Disabled
	@Test
	public void palindromeThree() {
		assertFalse(EserciziUtils.isPalindrome("junit"));
	}

	// 2. Scrivi una classe JUnit per testare un metodo che verifica se un numero è
	// primo o no. Il test dovrebbe coprire almeno due casi di input validi e uno
	// non valido.

//	//@Disabled
	@Test
	public void primiOne() {
		assertTrue(EserciziUtils.isPrime(13));
	}

//	//@Disabled
	@Test
	public void primiTwo() {
		assertTrue(EserciziUtils.isPrime(23));
	}

//	//@Disabled
	@Test
	public void primiThree() {
		assertTrue(EserciziUtils.isPrime(1));
	}

	// 3. Scrivi una classe JUnit per testare un metodo che calcola il fattoriale di
	// un numero intero positivo. Il test dovrebbe coprire almeno due casi di input
	// validi e uno non valido.

	//@Disabled
	@Test
	public void fattorialeOne() {
		int expected = 24;
		int actual = EserciziUtils.factorial(4);
		assertEquals(actual, expected);
	}

	//@Disabled
	@Test
	public void fattorialeTwo() {
		int expected = 720;
		int actual = EserciziUtils.factorial(5);
		assertEquals(actual, expected);
	}

	//@Disabled
	@Test
	public void fattorialeThree() {
		int expected = 6;
		int actual = EserciziUtils.factorial(-3);
		assertNotEquals(actual, expected);
	}

	// 4. Scrivi una classe JUnit per testare un metodo che cerca una stringa
	// all'interno di un'altra stringa e restituisce la posizione della prima
	// occorrenza. Se la stringa cercata non viene trovata, il metodo restituisce
	// null. Il test dovrebbe includere almeno un caso in cui la stringa cercata
	// viene trovata e un caso in cui la stringa cercata non viene trovata.

	//@Disabled
	@Test
	public void sottostringaOne() {
		Integer expected = 3;
		Integer actual = EserciziUtils.contains("valvola", "vola");
		assertEquals(actual, expected);
	}

	//@Disabled
	@Test
	public void sottostringaTwo() {
		assertNull(EserciziUtils.contains("valvola", "ciao"));
	}

}
