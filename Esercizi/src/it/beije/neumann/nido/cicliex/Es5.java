/*
 * Stampare a video la seguente figura:
 * #
 * ##
 * ###
 * ####
 * #####
 * ######
 */
package it.beije.neumann.nido.cicliex;

public class Es5 {

	public static void main (String[] args){
		for (int i=1; i<7; i++){ //righe
			for (int j=1; j<i+1; j++){ //colonne
				System.out.print('#');
			}
			System.out.println();
		}
	}

}
