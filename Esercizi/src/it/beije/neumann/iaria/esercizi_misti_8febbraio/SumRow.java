package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class SumRow {
	
	public void rowSumOddNumbers(int n) {
		int[][] triangoloDispari = {{1},{3,5},{7,9,11},{13,15,17,19},{21,23,25,27,29}};
		int lunghezzaRiga;
		int risultato = 0;
		
		if(n<1) {
			System.out.println("Inserisci un numero maggiore di 0");
	    } else if(n>triangoloDispari.length){
	    	System.out.println("Inserisci un numero minore di "+triangoloDispari.length);            
	    } else{
	    	lunghezzaRiga = triangoloDispari[n-1].length;
	    	for(int i=0; i<=lunghezzaRiga; i++){
	    		risultato += triangoloDispari[lunghezzaRiga][i];
	    	}
	    	System.out.println(risultato);
	    }
	}

	public static void main(String[] args) {
		SumRow sommariga = new SumRow();
		sommariga.rowSumOddNumbers(2);
	}

}
