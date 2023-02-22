package it.beije.neumann.mongiello;

public class MorraCinese {
	
static boolean checkInput( String input ) {

		input = input.trim().toLowerCase();
		if( "sasso".equals(input) || "carta".equals(input) || "forbici".equals(input) ) {
			return true;
		}else {
			System.out.println("Input errato.Riprova");
		}
		return false;
	}

	static void winner( String g1, String g2 ) {
		if( g1.equalsIgnoreCase(g2) ) {
			System.out.println("Avete pareggiato");
			}else if( g1.equalsIgnoreCase("sasso") && g2.equalsIgnoreCase("forbici") ) {
				System.out.println("Il vincitore è il giocatore 1 ");
			}else if( g1.equalsIgnoreCase("carta") && g2.equalsIgnoreCase("sasso") ) {
				System.out.println("Il vincitore è il giocatore 1 ");
			}else if( g1.equalsIgnoreCase("forbici") && g2.equalsIgnoreCase("carta") ) {
				System.out.println("Il vincitore è il giocatore 1 ");
		}else {
			System.out.println("Il vincitore è il giocatore 2 ");
		}
		
	}

}
