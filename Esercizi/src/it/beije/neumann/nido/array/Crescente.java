/*
 * Verificare la sequenza crescente di un array.
 * Il metodo “boolean isCrescente(int [] array)”
 * restituisce true se tutti gli elementi dell’array
 * passato sono in ordine crescente, false altrimenti.
 */
package it.beije.neumann.nido.array;

public class Crescente {

	public static boolean isCrescente(int[] array) {

		boolean result = true;

		for (int i = 0; i < array.length - 1; i++) {
			int j = i + 1;
			if (array[i] > array[j]) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 7, 4, 4, 5 };
		int[] arr2 = new int[] { 1, 2, 3, 4, 4, 5 };

		System.out.println("Primo array crescente? -> "+isCrescente(arr1));
		System.out.println("Secondo array crescente? -> "+isCrescente(arr2));

	}

}
