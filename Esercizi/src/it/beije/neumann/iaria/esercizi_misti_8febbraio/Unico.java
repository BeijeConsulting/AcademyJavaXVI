package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class Unico {
	
    public static String carattereUnico(String s){
    	s = s.toLowerCase(); //Trasforomo la stringa in minuscolo per non fare distinzioni
    	String risultato = "";
    	String lettera = "";
    	String copiaDis = "";
    	StringBuilder sb = null;
        
        //Scorro la stringa
        for(int i=0; i<s.length(); i++) {
        	lettera += s.charAt(i); //Prendo la lettera all'indice corrispondente
        	sb = new StringBuilder(s); //Creo uno StringBuilder copia della stringa
        	sb.deleteCharAt(i); //Elimino la lettera considerata
        	copiaDis += sb; //Trasformo la copia della stringa (che è StringBuilder) in String
        	
        	if(copiaDis.contains(lettera)) { //Se la stringa (che non ha il carattere selezionato) contiene il carattere
        		risultato+=")";  //Stampa ) 
        		lettera = "";   //Reset lettera
        		copiaDis = "";  //Reset copia stringa
        	} else {
        		risultato+="(";
        		lettera = "";
        		copiaDis = "";
        	}
        }        
        return risultato;
      }

	public static void main(String[] args) {
		String risultato = carattereUnico("ciaoIco");
		System.out.println(risultato);
	}

}
