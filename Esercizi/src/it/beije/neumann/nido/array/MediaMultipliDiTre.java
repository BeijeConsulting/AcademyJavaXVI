/*
 * Scrivere un programma MediaMultipliDiTre che calcoli la media di un array
 * di numeri interi, considerando i soli numeri divisibili per tre.
 */
package it.beije.neumann.nido.array;

public class MediaMultipliDiTre {

	public static void main(String[] args) {
		int[] numbers = new int[]{5,3,7,9,12,2,3,5,4};
		
		float media = 0.0F;
		int divis3 = 0;
		
		for (int i=0; i<numbers.length; i++) {
			if(numbers[i]%3==0) {
				media = media+numbers[i];
				divis3++;
			}
		}
		
		System.out.println("Media -> "+ media/divis3);
		
	}

}
