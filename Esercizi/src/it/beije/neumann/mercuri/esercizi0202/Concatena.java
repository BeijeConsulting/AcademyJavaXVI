package it.beije.neumann.mercuri.esercizi0202;

public class Concatena {

	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder();
		
		for (String parola: args)	{
			
			str.append(parola).append("*");
		}

		System.out.println(str.substring(0,str.length() - 1));
	}

}
