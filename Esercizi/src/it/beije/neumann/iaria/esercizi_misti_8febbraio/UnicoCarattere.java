package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class UnicoCarattere {
	
	 public static int persistenza(int n) {
		 int persistenzaMoltiplicativa = 0;
		 int risultato = 0;
		 
		 if(n<0) {
			 persistenzaMoltiplicativa = 0;
		 } else if(n<10){
			 persistenzaMoltiplicativa = 1;
		 } else if(n>10 && n<100) {
			 while(n>10) {
				 persistenzaMoltiplicativa++;
				 risultato = (n/10)*(n%10); //Numero a sx * Numero a dx
				 n = risultato;  //n diventa risultato
				 risultato = 1;  //Reset risultato
			 }
		 } else if(n>100) {
			 while(n>10) {
				 persistenzaMoltiplicativa++;
				 risultato = (n/100)*((n/10)%10)*(n%10); //Numero a sx * Numero al centro * Numero a dx
				 n = risultato;  //n diventa risultato
				 risultato = 1;  //Reset risultato
			 }
		 }
		 
		 return persistenzaMoltiplicativa;
	 }

	public static void main(String[] args) {
		int risultato = persistenza(999);
		System.out.println(risultato);
	}

}
