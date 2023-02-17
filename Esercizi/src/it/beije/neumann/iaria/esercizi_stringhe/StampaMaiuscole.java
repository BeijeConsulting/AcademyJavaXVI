package it.beije.neumann.iaria.esercizi_stringhe;

public class StampaMaiuscole {

	public static void main(String[] args) {
		String[] stringa1 = {"Prova"};
		String[] stringa2 = {"mAiuscole"};
		String[] stringa3 = {"Diagonale"};
		char iniziale = stringa1[0].charAt(0);
		char iniziale2 = stringa2[0].charAt(0);
		char iniziale3 = stringa3[0].charAt(0);
		if(Character.isUpperCase(iniziale)) {
			System.out.println(iniziale);
		}if(Character.isUpperCase(iniziale2)) {
			System.out.println(iniziale2);
		}if(Character.isUpperCase(iniziale3)) {
			System.out.println(iniziale3);
		}
	}
}