package it.beije.neumann.elassl.feb2;


public class Vettori {
	public int max(int[] arr) {
		if (arr.length == 0)
			return -1;
		int currmax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currmax)
				currmax = arr[i];
		}
		return currmax;
	}

	public int maxIndex(int[] arr) {
		if (arr.length == 0)
			return -1;
		int currmax = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > currmax) {
				currmax = arr[i];
				index = i;
			}
		}
		return index;
	}

	boolean contains(int e, int[] array) {
		for (int num : array)
			if (num == e)
				return true;
		return false;
	}

	boolean contains(Object e, Object[] array) { // a differenza di quello precedente controllo l'uguaglianza tramite il
													// metodo equals di object e non i valori
		for (Object elem : array)
			if (elem.equals(e))
				return true;
		return false;
	}

	public int mostRecurrent(int[] array) {
		int maxValue = array[0];
		int maxCount = 0;
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == array[i])
					count++;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	public int mediaMultipliDiTre(int[] numeri) {
		int sum = 0;
		int count = 0;
		for (int num : numeri) {
			if (num % 3 == 0) {
				count++;
				sum += num;
			}
		}
		if (count > 0) {
			return sum / count;
		}
		return -1;
	}

	public void stampaZigZag(int[] numeri) {
		for (int i = 0; i < 5; i++)
			System.out.print(numeri[i] + " " + numeri[numeri.length - i - 1] + " ");

	}

	public int media(int[] numeri) {
		int sum = 0;
		int count = 0;
		for (int num : numeri) {
			count++;
			sum += num;
		}
		if (count > 0) {
			return sum / count;
		}
		return -1;
	}

	public String[] addString(String s, String[] a) {
		int len = a.length + 1;
		String[] result = new String[len];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		result[a.length] = s;
		return result;
	}

	public static void main(String[] args) {

		Vettori t1 = new Vettori();
		System.out.print("\n\nEsercizio 1:\n");
		int[] numeri = { 1, 3, 4, 5, 2 };
		System.out.print(t1.max(numeri));
		System.out.print("\n\nEsercizio 2:\n");
		System.out.print(t1.maxIndex(numeri));
		System.out.print("\n\nEsercizio 3:\n");
		System.out.print(t1.contains(1, numeri));
		System.out.print("\n\nEsercizio 4:\n");
		System.out.print(t1.contains(new Integer(1), numeri));
	}

}

