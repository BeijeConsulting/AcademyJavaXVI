package esercizi0202;

public class StampaMetodi {

	
	static void stampaSetter (String variabile) {
		
		StringBuilder metodo = new StringBuilder();
		
		String upVar = variabile.substring(0,1).toUpperCase() + variabile.substring(1);
		
		metodo.append("public void set").append(upVar).append("() { this.").append(variabile).append(" = ").append(variabile).append("; }");
		
		System.out.println(metodo.toString());
		
	}
	public static void main(String[] args) {
	
		StampaMetodi.stampaSetter("aiuto");

	}

}
