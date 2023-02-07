package it.beije.neumann.mongiello;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//Esecuzione e test metodi clase StringUtils 
		String str = new String("prova");
		try {
			System.out.print( StringUtils.replace( str, '1', 'd' ));
		}catch( NoCharException ec ) {
			System.out.println("Non ci sono caratteri");
		}
	
	//Esecuzione morraCinese
		Scanner tastiera1 = new Scanner(System.in);	
		String giocatore1;
		String giocatore2;

		System.out.println("Ciao giocatore 1 cosa vuoi scegliere? ");
		do{
			giocatore1 = tastiera1.nextLine();	
		}while( !MorraCinese.checkInput( giocatore1 )  );

		System.out.println("Ciao giocatore 2 cosa vuoi scegliere? ");
		do{
			giocatore2 = tastiera1.nextLine();	
		}while( ! MorraCinese.checkInput( giocatore2 )  );
		
		MorraCinese.winner( giocatore1, giocatore2 );
	}

}
