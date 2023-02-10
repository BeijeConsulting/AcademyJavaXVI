/*
 * Scrivere il metodo: “public String [] addString(String s, String[] a)”,
 * che accetta come parametri una stringa ed un array di stringhe.
 * Restituisce un nuovo array, identico ad array, aggiungendo però,
 * come ultimo elemento, la stringa s.
 */
package it.beije.neumann.nido.array;

public class AddString {
	
	public static String[] addString(String s, String[] a) {
		int dim = a.length;
		String[] newStringArr = new String[dim+1];
		
		for(int i=0;i<dim+1;i++) {
			if(i==dim) {
				newStringArr[i] = s;
			}else {
				newStringArr[i] = a[i];
			}
		}
		return newStringArr;
	}

	public static void main(String[] args) {
		String[] result = addString("Aggiunta",args);
		
		for(String s:result) {
			System.out.println("# "+s);
		}
	}

}
