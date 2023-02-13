package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class VerificaParentesi {
	
    public static boolean groupCheck(String s){
    	boolean risultato;
        String copia = "";
        String[] lettereMin = {"a","b","c","d","e","f","g","h","i","l","m","n","o","p","q","r","s","t","u","v","z","x","j","k","w","y"};
        String[] lettereMaiu = {"A","B","C","D","E","F","G","H","I","L","M","N","O","P","Q","R","S","T","U","V","Z","X","J","K","W","Y"};
        while (s.length() != copia.length()){ //Finché s e la sua copia sono diversi
            copia = s; //copia sarà uguale ad s
            
            //Se ci sono lettere maiuscole o minuscole, le sostituisco con "" (cioè nulla)
            for(int i=0; i<lettereMin.length; i++) {
            	if(s.contains(lettereMin[i])) {
            		s = s.replace(lettereMin[i], "");
            	}
            	if(s.contains(lettereMaiu[i])) {
            		s = s.replace(lettereMaiu[i], "");
            	}
            }
            
            //Se ci sono parentesi tonde, quadre o graffe, le sostituisco con "" (cioè nulla)
            s = s.replace("()", "").replace("[]", "").replace("{}", "");     
         }
        if(s.length() == 0) { //Se s è vuota, vuol dire che  sono state trovate tutte le corrispondenze, quindi true
        	risultato = true;
        } else {
        	risultato = false;
        }
        return risultato;
        	
      }

	public static void main(String[] args) {
		boolean risultato;
		risultato = groupCheck("{[A]()[a]}");
		System.out.println(risultato);
	}

}
