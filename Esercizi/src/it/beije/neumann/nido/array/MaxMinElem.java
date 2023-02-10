/*
 * Trovare il massimo elemento in un array (o il minimo)
 */
package it.beije.neumann.nido.array;

public class MaxMinElem {
	
	public static int maxElem(int[] array) {
		int max=0;
		
		for(int i=0; i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		
		return max;
	}
	
	public static int minElem(int[] array) {
		int min=array[0];
		
		for(int i=0; i<array.length;i++) {
			if(array[i]<min) {
				min=array[i];
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		int[] array=new int[]{100,23,1,76};
		
		int maxV = maxElem(array);
		int minV = minElem(array);
		System.out.println("Massimo: "+maxV);
		System.out.println("Minimo: "+minV);

	}

}
