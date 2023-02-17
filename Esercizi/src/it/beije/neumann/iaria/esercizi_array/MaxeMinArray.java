package it.beije.neumann.iaria.esercizi_array;

public class MaxeMinArray {

	public static void main(String[] args) {
		int[] array = {23,41,2,35,84,4,1,75};
		int valoreMassimo = array[0];
		int valoreMinimo = array[0];
		for(int i=0; i<array.length; i++) {
			if(array[i]>valoreMassimo) {
				valoreMassimo = array[i];
			}
			if(array[i]<valoreMinimo) {
				valoreMinimo = array[i];
			}
		}
		System.out.println(valoreMassimo);
		System.out.println(valoreMinimo);
	}

}

