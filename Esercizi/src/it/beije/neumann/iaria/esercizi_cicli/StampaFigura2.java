package it.beije.neumann.iaria.esercizi_cicli;

public class StampaFigura2{
	public static int i,j;
	public static void main (String[] args){
		for(i=0; i<6; i++){
			for(j=1; j<=i; j++){
				System.out.print("#");
			}
			System.out.println();
		}
	}
}