/*
 * Scrivere un programma Media che calcoli la media di un array di numeri interi
 */
package it.beije.neumann.nido.array;

public class Media {

	public static void main(String[] args) {
		int[] numbers = new int[] {9,2,6,3,1,5,3,1,3,2};
		
		float media = 0.0F;
		
		for(int i=0; i<numbers.length;i++) {
			media = media + numbers[i];
		}
		
		System.out.println("Media -> "+ media/numbers.length);

	}

}
