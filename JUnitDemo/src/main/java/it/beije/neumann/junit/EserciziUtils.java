package it.beije.neumann.junit;

public class EserciziUtils {

	public static boolean isPalindrome(String word) {

		int start = 0;
		word = word.replace(" ", "").toLowerCase();
		int end = word.length() - 1;
		int axis = word.length() / 2;

		while (start < axis) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			} else {
				start = start + 1;
				end = end - 1;
			}
		}

		return true;
	}

	public static boolean isPrime(int number) {
		if (number <= 1) return false;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		
		return true;
	}

	public static int factorial(int positiveInt) {
		if (positiveInt < 1)
			throw new IllegalArgumentException("Attenzione, numero negativo!");

		int factorial = 1;

		for (int i = 1; i <= positiveInt; i++)
			factorial = factorial * i;

		return factorial;
	}

	public static Integer contains(String word, String substring) {
		int result = word.indexOf(substring);

		if (result == -1)
			return null;

		return result;
	}

}
