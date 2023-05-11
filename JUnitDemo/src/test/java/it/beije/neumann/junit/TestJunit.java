package it.beije.neumann.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestJunit {
	public boolean isPalindromo(String s) {
		for (int i = 0; i < (s.length() / 2); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i))
				return false;
		}
		return true;
	}

	public static boolean isPrimo(int n) {
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

	@Test
	public void testPalindrome() {
		assertEquals(true, isPalindromo("pippo"));
		assertEquals(true, isPalindromo("abba"));
		assertEquals(false, isPalindromo("prova"));
	}

	@Test
	public void testPrimeNumber() {
		assertEquals(true, isPrimo(7));
		assertEquals(true, isPrimo(31));
		assertEquals(false, isPrimo(10));
	}

	@Test
	public void factorialTest() {
		// assertEquals(1, calcolaFattoriale(1));
	}

	@Test
	public void testSearch() {
		assertEquals(4, trovaStringa("hello world", "o w"));
		assertEquals(null, trovaStringa("hello world", "xyz"));
	}

	public static Integer trovaStringa(String str, String searchStr) {
		int index = str.indexOf(searchStr);
		if (index == -1) {
			return null;
		}
		return index;
	}

}
