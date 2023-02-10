/*
 * Trovare l’indice del massimo elemento in un array (o il minimo)
 */
package it.beije.neumann.nido.array;

public class MinMaxPos {

	public static int maxPos(int[] array) {
		int max = 0;
		int maxPos = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				maxPos = i;
			}
		}

		return maxPos;
	}

	public static int minPos(int[] array) {
		int min = array[0];
		int minPos = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				minPos = i;
			}
		}

		return minPos;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 100, 23, 1, 76 };

		int maxPos = maxPos(array);
		int minPos = minPos(array);
		System.out.println("Massimo: " + maxPos);
		System.out.println("Minimo: " + minPos);

	}

}
