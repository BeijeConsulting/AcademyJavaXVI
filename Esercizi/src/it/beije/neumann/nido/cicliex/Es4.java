/*
 * Stampare a video la seguente figura:
 * *****
 * ****
 * ***
 * **
 * *
 */
package it.beije.neumann.nido.cicliex;

public class Es4 {

	public static void main (String[] args){
		for (int i=5; i>0; i--){ //riga
			for (int j=1; j<i+1; j++){ //colonna
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
