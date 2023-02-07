package esercizi0202;

import java.util.Scanner;

public class SoloVocali {
	
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String stringa = scanner.next();
		
		for (int i = 0; i < stringa.length(); i++) {
			
			if (stringa.charAt(i) == 'a' ||stringa.charAt(i) == 'e' || stringa.charAt(i) == 'i' ||stringa.charAt(i) == 'o' ||stringa.charAt(i) == 'u' ) {
				
				System.out.print(stringa.charAt(i));
				
				
			}
			
			//oppure switch
		}
		
		
		scanner.close();
		
	}

}