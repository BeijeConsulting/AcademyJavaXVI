/*
 * Scrivere un programma StampaZigZag che, dato un array di 10 numeri
 * interi contenente valori a piacere, ne stampa gli elementi secondo
 * il seguente ordine: il primo, l’ultimo, il secondo, il penultimo,
 * il terzo, il terz’ultimo, ecc…
 */
package it.beije.neumann.nido.array;

public class StampaZigZag {

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		int dim = array.length;
		int half = dim/2;
		
		for(int i=0,j=dim-1;(i<half && j>half-1);i++,j--) {
			System.out.println(array[i]+"\n"+array[j]);
		}

	}

}
