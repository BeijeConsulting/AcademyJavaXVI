package it.beije.neumann.mongiello.rubrica;

import java.io.IOException;

public class Check {
	
	public static boolean checkScelta( int scelta ) throws IOException {
		
		if( scelta > 0 && scelta <= 6 ) {
			return true;
		}
		throw new IOException("Scelta non valida") ;
	}
	
	public static boolean isAlpha( String field ) throws IOException  {
		
		boolean check = false;
		field = field.trim().toLowerCase();
		
		for( int i = 0; i < field.length(); i++ ) {
			if( field.charAt(i) >= 'a' && field.charAt(i) <= 'z') {
				check = true;
			}else{
				throw new IOException("Sono ammesse solo lettere");
			}
		}
		return check;
	}
	
	
	
}
