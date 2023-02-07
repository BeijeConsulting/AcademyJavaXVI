package it.beije.neumann.elassl.feb2;


public class Stringhe {
	private String vocali = "aeiou";

	public void es1(String str) {
		for (char letter : str.toCharArray()) {
			if (vocali.contains(String.valueOf(Character.toLowerCase(letter)))) {
				System.out.print(letter);
			}
		}
	}

	public void es2(String[] str) {
		for (String word : str) {
			if (word != null && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
				System.out.print(word);
			}
		}
	}

	public int contaLettera(char c, String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public void contrario(String str) {
		for (int i = str.length() - 1; i >= 0; i--)
			System.out.print(str.charAt(i));

	}

	public void concatena(String str[]) {
		if (str == null)
			return;
		if (str.length == 1) {
			System.out.print("\n" + str[0]);
			return;
		} else {
			System.out.print("\n" + str[0]);
		}
		for (int i = 1; i < str.length; i++) {
			System.out.print("*" + str[i]);
		}
	}

	public void setter(String str) {
		System.out.print("\n set" + str.substring(0, 1).toUpperCase() + str.substring(1));
		System.out.print("(...)");
	}

	public void getter(String str) {
		System.out.print("\n get" + str.substring(0, 1).toUpperCase() + str.substring(1));
		System.out.print("()");
	}

	public static void main(String[] args) {
		Stringhe t1 = new Stringhe();
		System.out.print("\n\nEsercizio 1:\n");
		t1.es1("provaA");
		System.out.print("\n\nEsercizio 2:\n");
		String[] s = { "provaA", "Prova1", "provaA", "Prova2" };
		t1.es2(s);
		System.out.print("\n\nEsercizio 3:\n");
		System.out.println(t1.contaLettera('v', "provaA"));
		System.out.print("\n\nEsercizio 4:\n");
		t1.contrario("provaA");
		System.out.print("\n\nEsercizio 5:\n");
		t1.concatena(s);
		System.out.print("\n\nEsercizio 6:\n");
		t1.concatena(s);
		System.out.print("\n\nEsercizio 7:\n");
		t1.concatena(s);

	}
}

