/*
 * Scrivere un metodo che, data una stringa in input,
 * assuma questa come un nome di variabile e stampi
 * per questa variabile il suo metodo “setter”.
 * 
 * Scrivere un metodo che, data una stringa in input,
 * assuma questa come un nome di variabile e stampi
 * per questa variabile il suo metodo “getter”.
 */
package it.beije.neumann.nido.stringex;

public class GetSet {

	public static void printSet(String variable) {
		String newVar = new StringBuilder(variable.replace(variable.substring(0, 1), variable.substring(0, 1).toUpperCase())).toString();
		StringBuilder out = new StringBuilder();
		out.append("public void set");
		out.append(newVar);
		out.append("(T ciao){\n");
		out.append("   this."+variable+"="+variable+";\n");
		out.append("}\n");
		
		System.out.println(out);
	}
	
	public static void printGet(String variable) {
		String newVar = new StringBuilder(variable.replace(variable.substring(0, 1), variable.substring(0, 1).toUpperCase())).toString();
		StringBuilder out = new StringBuilder();
		out.append("public T get");
		out.append(newVar);
		out.append("(){\n");
		out.append("   return this."+variable+";\n");
		out.append("}\n");
		
		System.out.println(out);
	}
	

	public static void main(String[] args) {
		String prova = "ciao";
		
		printSet(prova);
		printGet(prova);
	}

}
