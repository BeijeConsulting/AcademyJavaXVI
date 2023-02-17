package it.beije.neumann.iaria.esercizi_cicli;

public class StampaFigura1{
	public static int i,j;
	public static void main (String[] args){
		for(i=1; i<7; i++){
			for(j=7-i; j>0; j--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}