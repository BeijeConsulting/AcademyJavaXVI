package it.beije.neumann.mercuri.esercizi0202;

public class StampaMaiuscole {
	

	public int contaLettera (char c, String str) {
		
		int counter = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == c)
				counter ++;
		}
		
		return counter;
	}
	
	public static void main (String [] args) {
		

		for (String parola: args) {
			
			String iniziale = parola.substring(0,1);
			
			if (iniziale.toUpperCase() == iniziale) {
				
				System.out.println(parola);
				
			}
		}
		
		System.out.print(new StampaMaiuscole().contaLettera('a',"marachella" ));
		
		
	}
}
