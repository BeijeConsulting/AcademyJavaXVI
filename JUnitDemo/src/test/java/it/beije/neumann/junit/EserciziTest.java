package it.beije.neumann.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EserciziTest {

	
	@Test
	void testPalindrome() {
		
		String s = "otto";
		
		assertTrue(Esercizi.isPalindrome(s));
		
	}
	
	@Test
	void testPrimeNumber() {
		int n = 13;
		
		assertTrue(Esercizi.isPrime(n));
	}
	
	@Test
	void testFactorial() {
		int num = 5;
		int expected = 120;
		int actual;
		
		actual = Esercizi.factorial(num);
		
		assertEquals(expected, actual);
	}
}
