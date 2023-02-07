package it.beije.neumann.iaria.esercizi_stringhe;

public class ConteggioLettere {
	
	public int contaLettera(char c, String str) {
		int occorrenze = 0;
		for(int i=0; i<str.length(); i++) {
			char lettera = str.charAt(i);
			if(lettera == c) {
				occorrenze++;
			}
		}
		return occorrenze;
	}

	public static void main(String[] args) {
		ConteggioLettere contaOccorrenze = new ConteggioLettere();
		System.out.println(contaOccorrenze.contaLettera('i',"Ripudio"));
	}

}
