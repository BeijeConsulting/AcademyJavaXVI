package it.beije.neumann.vellani.feb2;

public class Stringhe {

	public static void main(String[] args) {

		Stringhe.SoloVocali("Ciao sono Federico");
		System.out.println();
		Stringhe.StampaMaiuscole("Prova consonanti aereo");
		System.out.println();
		System.out.println(Stringhe.contaLettera('a', "Sudamerica"));
	}
	
	public static void SoloVocali(String s) {
		char[] string = s.toCharArray();
		
		for(char c : string) {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == ' ') {
				System.out.print(c);
			}
		}
	}
	
	public static void StampaMaiuscole(String s) {
		String[] array = s.split(" ");
		
		for(String e : array) {
			if(e.charAt(0) != 'a' && e.charAt(0) != 'e' && e.charAt(0) != 'i' && e.charAt(0) != 'o' && e.charAt(0) != 'u' && e.charAt(0) != 'A' && e.charAt(0) != 'E' && e.charAt(0) != 'I' && e.charAt(0) != 'O' && e.charAt(0) != 'U'){
				System.out.print(e + " ");
			}
		}
	}
	
	
	public static int contaLettera(char c, String str) {
		int totale = 0;
		char[] array = str.toCharArray();
		for(int i = 0; i < array.length; i++) {
			if(array[i] == c) {
				totale++;
			}
		}
		return totale;
	}
}
