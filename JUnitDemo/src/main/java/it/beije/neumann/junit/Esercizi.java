package it.beije.neumann.junit;

public class Esercizi {
	public static boolean isPalindrome(String str) {
        // Null check
        if (str == null) {
            return false;
        }

        // Empty string is considered as palindrome
        if (str.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
	public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
	public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }
	public static Integer findString(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return (index != -1) ? index : null;
    }

}
