package it.beije.neumann.mercuri.esercizi0302;

public class MorraCinese {

	public static void main(String[] args) {
		//pessimo
		
		switch (args[0]) {
		
		case "sasso" : switch (args[1]) { 		case "sasso" : System.out.println("pareggio"); break;
												case "forbici" : System.out.println("args[0] vince con sasso"); break;
												case "carta": System.out.println("args[1] vince con carta"); break;
										}; break;
		case "forbici" : switch (args[1]) { 	case "sasso" : System.out.println("args[1] vince con sasso"); break;
												case "forbici" : System.out.println("pareggio"); break;
												case "carta": System.out.println("args[0] vince con borbici"); break;
										}; break;
		case "carta" : switch (args[1]) { 		case "sasso" : System.out.println("args[0] vince con carta"); break;
												case "forbici" : System.out.println("args[1] vince con forbici"); break;
												case "carta": System.out.println("pareggio"); break;
										}; break;
		}

	}

}
