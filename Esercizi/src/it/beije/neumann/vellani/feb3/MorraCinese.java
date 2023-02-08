package it.beije.neumann.vellani.feb3;

public class MorraCinese {

	public static void main(String[] args) {
		
		String giocatore1 = args[0];
	    String giocatore2 = args[1];
	    System.out.println("Il giocatore 1 ha scelto: " + giocatore1);
	    System.out.println("Il giocatore 2 ha scelto: " + giocatore2);
	    if (giocatore1.equals(giocatore2)) {
	      System.out.println("Pareggio!");
	    } else if (
	        (giocatore1.equals("sasso") && giocatore2.equals("forbici")) ||
	        (giocatore1.equals("carta") && giocatore2.equals("sasso")) ||
	        (giocatore1.equals("forbici") && giocatore2.equals("carta"))
	    ) {
	      System.out.println("Il giocatore 1 vince!");
	    } else {
	      System.out.println("Il giocatore 2 vince!");
	    }	
	    
	}

}
