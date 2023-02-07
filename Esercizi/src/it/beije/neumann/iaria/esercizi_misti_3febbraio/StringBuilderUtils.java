package it.beije.neumann.iaria.esercizi_misti_3febbraio;

public class StringBuilderUtils {
	
	//StringBuilder append(StringBuilder sb, String str)
	public static StringBuilder append(StringBuilder sb, String str) {
		StringBuilder stringbuilderCompleta;
		String sbToString = "";
		for(int i=0; i<sb.length(); i++) {
			char lettera = sb.charAt(i);
			sbToString+=lettera;
		}
		stringbuilderCompleta = new StringBuilder(sbToString+str);
		return stringbuilderCompleta;
	}
	
	//StringBuilder insert(StringBuilder sb, int offset, String str)
	public static StringBuilder insert(StringBuilder sb, int offset, String str) {
		StringBuilder stringbuilderCompleta;
		String sbToString = "";
		//Casi particolari
		//Se offset maggiore della lunghezza della stringa
		if(offset > sb.length()) {
			return stringbuilderCompleta = new StringBuilder("Numero troppo grande");
		} else if(offset < 0) { //Se minore di 0
			return stringbuilderCompleta = new StringBuilder("Non sono ammessi numeri negativi");
		} else if(offset == 0) {
			sbToString+=str;
			for(int i=0; i<sb.length(); i++) {
				char lettera = sb.charAt(i);
				sbToString+=lettera;
			}
			return stringbuilderCompleta = new StringBuilder(sbToString);
		}
		for(int i=0; i<sb.length(); i++) {
			if(i==offset) {
				sbToString+=str;
			}
			char lettera = sb.charAt(i);
			sbToString+=lettera;
		}
		stringbuilderCompleta = new StringBuilder(sbToString);
		return stringbuilderCompleta;	
	}
	
	//StringBuilder delete(StringBuilder sb, int start, int end)
	public static StringBuilder delete(StringBuilder sb, int start, int end) {
		StringBuilder stringbuilderConDelete;
		String sbToString = "";
		if(start > sb.length() || end > sb.length()) {
			return stringbuilderConDelete = new StringBuilder("Numero troppo grande");
		}
		for(int i=0; i<sb.length(); i++) {
			char lettera = sb.charAt(i);
			if(i<start || i>start && i==end || i>end) {
				sbToString+=lettera;
			}
		}
		return stringbuilderConDelete = new StringBuilder(sbToString);
	}
	
	//StringBuilder deleteCharAt(StringBuilder sb, int index)
	public static StringBuilder deleteCharAt(StringBuilder sb, int index) {
		StringBuilder stringbuilderConDelete;
		String sbToString = "";
		for(int i=0; i<sb.length(); i++) {
			char lettera = sb.charAt(i);
			if(i != index) {
				sbToString+=lettera;
			}
		}
		return stringbuilderConDelete = new StringBuilder(sbToString);
	}
	
	//StringBuilder reverse(StringBuilder sb)
	public static StringBuilder reverse(StringBuilder sb) {
		StringBuilder stringbuilderReverse;
		String sbToString = "";
		for(int i=sb.length()-1; i>=0; i--) {
			char lettera = sb.charAt(i);
			sbToString+=lettera;
		}
		return stringbuilderReverse = new StringBuilder(sbToString);
	}
	
	//boolean equals(StringBuilder sb1, StringBuilder sb2)
	public static boolean equals(StringBuilder sb1, StringBuilder sb2) {
		if(sb1.length() > sb2.length() || sb1.length() < sb2.length()) { //Se sb1 ha più lettere di sb2 o viceversa, torna falso
			return false;
		}
		for(int i=0; i<sb1.length(); i++) { //Altrimenti controlla lettera per lettera tra sb1 e sb2
			char letterasb1 = sb1.charAt(i);
			char letterasb2 = sb2.charAt(i);
			if(letterasb1 != letterasb2) { //Se sono diverse torna true
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StringBuilder risultato;
		boolean risultatoBooleano;
		//risultato = StringBuilderUtils.append(new StringBuilder("Ciao"), " Gianfranco");
		//risultato = StringBuilderUtils.insert(new StringBuilder("animals"), 3, "-");
		//risultato = StringBuilderUtils.delete(new StringBuilder("animals"), 1, 3);
		//risultato = StringBuilderUtils.deleteCharAt(new StringBuilder("animals"), 3);
		//risultato = StringBuilderUtils.reverse(new StringBuilder("animals"));
		risultatoBooleano = StringBuilderUtils.equals(new StringBuilder("animals"), new StringBuilder("animals"));
		//System.out.println(risultato);
		System.out.println(risultatoBooleano);
	}

}
