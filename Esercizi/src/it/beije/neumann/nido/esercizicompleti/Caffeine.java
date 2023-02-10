/*
 * Scrivere la funzione caffeina(int n) che prende
 * un numero positivo come argomento e:
 * - Se il numero è divisibile per 3, stampa “Java”
 * - Se il numero è divisibile per 3 e per 4, stampa “Coffee”
 * - Se il numero appartiene ad uno dei due casi precedenti
 * 	 ed è pari, aggiunge “Script” in fondo alla stringa
 * - Se non appartiene a nessuno dei casi precedenti stampa “match_missed!”
 */
package it.beije.neumann.nido.esercizicompleti;

public class Caffeine {
	
	public static boolean isNDiv(int number, int div) {
		return ((number%div)==0);
	}
	
	public static void caffeina(int n) {
		StringBuilder output = null;
		
		if (isNDiv(n,3)) {
			output = new StringBuilder("Java");
			
			if (isNDiv(n,2)) {
				output.append("Script");
			}
			
			if(isNDiv(n,4)) {
				output = new StringBuilder("Coffee");
				output.append("Script");
			}
		} else {
			output = new StringBuilder("match_missed!");
		}
		
		System.out.println(output.toString());
		
	}

	public static void main(String[] args) {
		System.out.print("caffeina(15) -> "); // Java (div3, non div4, non div2)
		caffeina(15);
		
		System.out.print("caffeina(12) -> "); // CoffeeScript (div3, div4, div2)
		caffeina(12);
		
		System.out.print("caffeina(5) -> "); // match_missed! (non div3, non div4, non div2)
		caffeina(5);
		
		System.out.print("caffeina(200) -> "); //match_missed! (non div3, div4, div2)
		caffeina(200);
		
		System.out.print("caffeina(18) -> "); //JavaScript (div3, non div4, div2)
		caffeina(18);

	}

}
