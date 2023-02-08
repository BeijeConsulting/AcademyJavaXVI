/*
 * Scrivere il metodo
 * public int contaLettera(char c, String str)
 * che conta le occorrenze della lettera c nella stringa str
 */
package it.beije.neumann.nido.stringex;

public class ContaLettera {
	
	public static int contaLettera(char c, String str) {
		int count=0;
		
		for(int i=0;i<str.length() ;i++) {
			if(str.charAt(i)==c) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {

		for(String stringa:args) {
			System.out.println(stringa+"\t"+contaLettera('a',stringa));
		}
		
	}

}
