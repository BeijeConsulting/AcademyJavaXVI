/*
 * scrivere un metodo “boolean contains(int e, int[] array)”
 * che restituisca true se l’elemento e è presente nell’array,
 * false altrimenti. Ripetere l’esercizio con
 * “boolean contains(Object e, Object[] array)”, quali differenze ci sono?
 */
package it.beije.neumann.nido.array;

public class variContains {

	public static boolean contains(int e, int[] array) {
		boolean found = false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == e) {
				found = true;
				break;
			}
		}

		return found;
	}

	public static boolean contains(Object e, Object[] array) {
		boolean found = false;

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(e)) {
				found = true;
				break;
			}
		}

		return found;
	}

	public static void main(String[] args) {
		int[] intArr = new int[] { 9, 1, 4, 6, 2, 5 };
		String[] objArr = new String[] { "ciao", "come", "va" };
		MixedElem[] mixArr = new MixedElem[] {new MixedElem(4,"Mary"),new MixedElem(5, "Anne")};

		int intToSearch = 1;
		String stringToSearch = "a";
		MixedElem mixToSearch = new MixedElem(4,"Mary");

		System.out.println("C'è l'elemento " + intToSearch + " nell'array? " + contains(intToSearch, intArr));
		System.out.println("C'è l'elemento " + stringToSearch + " nell'array? " + contains(stringToSearch, objArr));
		System.out.println("C'è l'elemento " + mixToSearch + " nell'array? " + contains(mixToSearch, mixArr));
	}

}
