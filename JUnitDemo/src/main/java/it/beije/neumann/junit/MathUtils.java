package it.beije.neumann.junit;

public class MathUtils {
	
	public static int subtraction (int a, int b) {		
		return a - b;
	}
	
	public static int[] arraySum(int[] a, int[] b) {
		int maxL = Math.max(a.length, b.length);
		int[] c = new int[maxL];
		for (int i = 0; i < maxL; i++) {
			int valA = 0;
			int valB = 0;
			if (i < a.length) {
				valA = a[i];
			}
			if (i < b.length) {
				valB = b[i];
			}
			c[i] = valA + valB;
		}
		return c;
	}
	
	public static String sumExpression(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < numbers.length; i++) {
			result.append(numbers[i] + " + ");
		}
		return result.toString();
	}

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}
	
	public static float division (int a, int b) {
		return a / b;
	}
}
