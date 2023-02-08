/*
 * Stampare a video la seguente figura:
 * 1      654321
 * 12      54321
 * 123      4321
 * 1234      321
 * 12345      21
 * 123456      1
 */
package it.beije.neumann.nido.cicliex;

public class Es6 {

	public static void main (String[] args){
		for(int i=1; i<7; i++){ //riga
			for(int j=1; j<i+1; j++){ //colonna gruppo 1
				System.out.print(j);
			}
			System.out.print("   ");
			for(int k=6-(i-1); k>0; k--){ //colonna gruppo 2
				System.out.print(k);
			}
			System.out.println();
		}
		
		
	}

}
