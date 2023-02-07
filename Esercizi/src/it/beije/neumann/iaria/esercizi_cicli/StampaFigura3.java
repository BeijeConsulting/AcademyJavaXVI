package it.beije.neumann.iaria.esercizi_cicli;

public class StampaFigura3{
	public static int i,j,k;
	public static void main (String[] args){
		for(i=1; i<7; i++){
			for(k=1; k<=i; k++){
				System.out.print(k);
			}
			System.out.print("     ");
			for(j=7-i; j>0; j--){
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
