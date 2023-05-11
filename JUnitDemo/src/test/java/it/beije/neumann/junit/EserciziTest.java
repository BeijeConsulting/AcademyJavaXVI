package it.beije.neumann.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EserciziTest {
	@Test
	public void testIsPalindrome() {
		Assertions.assertTrue(Esercizi.isPalindrome("radar"));
		Assertions.assertTrue(Esercizi.isPalindrome("madam"));
		Assertions.assertTrue(Esercizi.isPalindrome("")); // Empty string is considered as palindrome
		Assertions.assertFalse(Esercizi.isPalindrome("java"));
		Assertions.assertFalse(Esercizi.isPalindrome(null)); // Null string is not a palindrome
	}

	public void testIsPrime() {
		Assertions.assertTrue(Esercizi.isPrime(2)); // 2 is a prime number
		Assertions.assertTrue(Esercizi.isPrime(3)); // 3 is a prime number
		Assertions.assertFalse(Esercizi.isPrime(4)); // 4 is not a prime number
		Assertions.assertTrue(Esercizi.isPrime(5)); // 5 is a prime number
		Assertions.assertFalse(Esercizi.isPrime(0)); // 0 is not a prime number
		Assertions.assertFalse(Esercizi.isPrime(-1)); // Negative numbers are not prime
	}

	@Test
	public void testFactorial() {
		Assertions.assertEquals(120, Esercizi.factorial(5)); // 5! = 120
		Assertions.assertEquals(1, Esercizi.factorial(0)); // 0! = 1
		Assertions.assertEquals(1, Esercizi.factorial(1)); // 1! = 1
		Assertions.assertEquals(720, Esercizi.factorial(6)); // 6! = 720

		// Test for negative number, it should throw IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> Esercizi.factorial(-1));
	}
	@Test
    public void testFindString() {
        Assertions.assertEquals(Integer.valueOf(7), Esercizi.findString("Hello, world!", "world"));
        Assertions.assertNull(Esercizi.findString("Hello, world!", "earth"));

        // Test with needle at the start of haystack
        Assertions.assertEquals(Integer.valueOf(0), Esercizi.findString("Hello, world!", "Hello"));

        // Test with needle at the end of haystack
        Assertions.assertEquals(Integer.valueOf(12), Esercizi.findString("Hello, world!", "!"));

        // Test with empty needle, should return 0
        Assertions.assertEquals(Integer.valueOf(0), Esercizi.findString("Hello, world!", ""));

        // Test with empty haystack, should return null
        Assertions.assertNull(Esercizi.findString("", "Hello"));
    }
}
