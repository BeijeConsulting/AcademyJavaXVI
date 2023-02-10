/*
 * Scrivere un programma che stampi le tabellina del numero dato come argomento
 */
package it.beije.neumann.nido.cicli;

public class Es3 {

	public static void main(String[] args){
		System.out.println("Numero inserito: "+args[0]+"\nTabellina:");
		
		for (int i=0; i<=10; i++){
			System.out.println(args[0]+" x "+i+" = "+Integer.parseInt(args[0])*i);
		}
	}

}
