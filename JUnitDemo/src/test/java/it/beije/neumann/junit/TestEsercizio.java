package it.beije.neumann.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestEsercizio {

	@Test
	void testIsPalindrome1() {
		assertTrue(Esercizio.isPalindrome("iaai"));
	}
	@Test
	void testIsPalindrome2() {
		assertTrue(Esercizio.isPalindrome("itopinonavevanonipoti"));
	}
	@Test
	void testIsPalindrome3() {
		assertTrue(Esercizio.isPalindrome("ciao"));
	}
	
	@Test
	void testisPrime1() {
		assertTrue(Esercizio.isPrime(2));
	}
	
	@Test
	void testisPrime2() {
		assertTrue(Esercizio.isPrime(3));
	}
	@Test
	void testisPrime3() {
		assertTrue(Esercizio.isPrime(10));
	}
	
	@Test
	void testFattoriale1() {
		int expected = 120;
		int actual;
		
		actual = Esercizio.fattoriale(5);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFattoriale2() {
		int expected = 6;
		int actual;
		
		actual = Esercizio.fattoriale(3);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFattoriale3() {
		int expected = 120;
		int actual;
		
		actual = Esercizio.fattoriale(4);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testStringhe1() {
		Integer expected = 1;
		Integer actual;
		
		actual = Esercizio.trovaPosizione("ic",  "nicole");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testStringhe2() {
		
		Integer actual;
		
		actual = Esercizio.trovaPosizione("null",  "nicole");
		
		assertNull(actual);
	}
	
}
