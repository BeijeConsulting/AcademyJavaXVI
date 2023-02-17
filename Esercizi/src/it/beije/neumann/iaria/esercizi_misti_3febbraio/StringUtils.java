package it.beije.neumann.iaria.esercizi_misti_3febbraio;

public class StringUtils {

	//indexOf(String s, char c)
	public static String indexOf(String s, char c) {
		int IndiceCorrispondente = 0;
		for(int i=0; i<s.length(); i++) {
			char lettera = s.charAt(i);
			if(lettera == c) {
				IndiceCorrispondente = i;
			}
		}
		return IndiceCorrispondente + "";
	}
	
	//indexOf(String s, char c, index fromIndex)
	public static String indexOf(String s, char c, int fromIndex) {
		int IndiceCorrispondente = 0;
		for(int i=fromIndex; i<s.length(); i++) {
			char lettera = s.charAt(i);
			if(lettera == c) {
				IndiceCorrispondente = i;
				break;
			}
		}
		return IndiceCorrispondente + "";		
	}
	
	//indexOf(String s, String str)
	public static String indexOf(String s, String str) {
		int j;
		int x = 0;
		boolean trovato = false;
		int IndiceCorrispondente = -1;
		char letteradx = str.charAt(x);
		if(str.length()>1) { //Se la parola da cercare ha più di una lettera
			for(int i=0; i<s.length(); i++) {
				if(trovato==true) {  //Se la parola è già stata trovata, ferma il ciclo
					break;
				}
				char letterasx = s.charAt(i);
				if(letterasx == letteradx) { //Se la lettera della parola è uguale alla prima lettera da cercare (str.charAt(x) con x = 0)
					IndiceCorrispondente = i;
					x++; //Aumenta x per verificare la lettera successiva della parola da cercare
					letteradx = str.charAt(x); //E ovviamente aggiorna la variabile con la x aumentata
					for(j=i+1; j<s.length(); j++) { //A questo punto usiamo un altro for per scorrere le lettere della parola
						letterasx = s.charAt(j);  //Prendo la lettera della parola
						if(letterasx == letteradx) {  //Se è uguale alla lettera (aggiornata con x++) della parola da cercare
							if(x == str.length()-1) { //Se siamo all'ultima lettera della parola da cercare
								trovato = true;			//Vuol dire che abbiamo trovato la parola e fermiamo il ciclo
								break;
							} else {   //Altrimenti aumentiamo l'indice x per leggere la prossima lettera
								x++;
								letteradx = str.charAt(x);
							}
						} else {  //Se non è stata trovata alcuna lettera uguale, ferma il ciclo e setta IndiceCorrispondente a -1
							x=0;
							letteradx = str.charAt(x);
							IndiceCorrispondente = -1;
							break;
						}
					}
				}
			}
		} else if(str.length() > s.length()) { //Se la parola da cercare ha più lettera della stringa
			IndiceCorrispondente = -1;
		} else { //Se la parola da cercare ha 1 sola lettera
			for(int i=0; i<s.length(); i++) {
				char letterasx = s.charAt(i);
				if(letterasx == letteradx){
					IndiceCorrispondente = i;
				}
			}
		}

		return IndiceCorrispondente + "";
	}
	
	//indexOf(String s, String str, index fromIndex)
	public static String indexOf(String s, String str, int fromIndex) {
		int j;
		int x = 0;
		boolean trovato = false;
		int IndiceCorrispondente = -1;
		char letteradx = str.charAt(x);
		if(str.length()>1) { //Se la parola da cercare ha più di una lettera
			for(int i=fromIndex; i<s.length(); i++) {  //for che parte dall'index passato
				if(trovato==true) {   //Se la parola è già stata trovata, ferma il ciclo
					break;
				}
				char letterasx = s.charAt(i);
				if(letterasx == letteradx) { //Se la lettera della parola è uguale alla prima lettera da cercare (str.charAt(x) con x = 0)
					IndiceCorrispondente = i;
					x++;  //Aumenta x per verificare la lettera successiva della parola da cercare
					letteradx = str.charAt(x);  //E ovviamente aggiorna la variabile con la x aumentata
					for(j=i+1; j<s.length(); j++) { //A questo punto usiamo un altro for per scorrere le lettere della parola
						letterasx = s.charAt(j);  //Prendo la lettera della parola
						if(letterasx == letteradx) {  //Se è uguale alla lettera (aggiornata con x++) della parola da cercare
							if(x == str.length()-1) {  //Se siamo all'ultima lettera della parola da cercare
								trovato = true;  //Vuol dire che abbiamo trovato la parola e fermiamo il ciclo
								break;
							} else {  //Altrimenti aumentiamo l'indice x per leggere la prossima lettera
								x++;
								letteradx = str.charAt(x);
							}
						} else {  //Se non è stata trovata alcuna lettera uguale, ferma il ciclo e setta IndiceCorrispondente a -1
							x=0;
							letteradx = str.charAt(x);
							IndiceCorrispondente = -1;
							break;
						}
					}
				}
			}
		} else if(str.length() > s.length()) {  //Se la parola da cercare ha più lettera della stringa
			IndiceCorrispondente = -1;
		} else {
			for(int i=fromIndex; i<s.length(); i++) { //Se la parola da cercare ha 1 sola lettera, inizia dall'index passato
				char letterasx = s.charAt(i);
				if(letterasx == letteradx){
					IndiceCorrispondente = i;
					break;
				}
			}
		}

		return IndiceCorrispondente + "";
	}
	
	//String substring(String s, int beginIndex)
	public static String substring(String s, int beginIndex) {
		String subStringa = "";
		for(int i=beginIndex; i<s.length(); i++) {
			char lettereSub = s.charAt(i);
			subStringa = subStringa+lettereSub;
		}
		return subStringa;
	}
	
	//String substring(String s, int beginIndex, int endIndex)
	public static String substring(String s, int beginIndex, int endIndex) {
		String subStringa = "";
		if(endIndex<=s.length()) {
			for(int i=beginIndex; i<endIndex; i++) {
				char lettereSub = s.charAt(i);
				subStringa = subStringa+lettereSub;
			}
		} else {
			subStringa = subStringa+-1;
		}
		return subStringa;
	}
	
	//String toLowerCase(String s)
	public static String toLowerCase(String s) {
		char[] arrayMaiuscole = {'A','B','C','D','E','F','G','H','I','L','M','N','O','P','Q','R','S','T','U','V','Z','X','K','J','Y','W'};
		char[] arrayMinuscole = {'a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','z','x','k','j','y','w'};
		String stringaMinuscola = "";
		for(int i=0; i<s.length(); i++) {
			char lettera = s.charAt(i);
			char letteraconfronto = lettera; //Mi servirà per il confronto
			for(int j=0; j<arrayMaiuscole.length; j++) {  //Se la lettera contiene una lettera MAIUSCOLA
				if(lettera == arrayMaiuscole[j]) {  //Prenderà il valore corrispondente MINUSCOLA
					lettera = arrayMinuscole[j];  //Inserisco la lettera dentro la stringa stringaMaiuscola
					stringaMinuscola += lettera;
				}
			} if(lettera == letteraconfronto) { //Se la lettera non è stata resa minuscola, inseriscila
				stringaMinuscola += lettera;   //(Cioè non è stata resa minuscola, inseriscila)
			}
		}
		return stringaMinuscola;
	}
	
	//String toUpperCase(String s)
	public static String toUpperCase(String s) {
		char[] arrayMaiuscole = {'A','B','C','D','E','F','G','H','I','L','M','N','O','P','Q','R','S','T','U','V','Z','X','K','J','Y','W'};
		char[] arrayMinuscole = {'a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','z','x','k','j','y','w'};
		String stringaMaiuscola = "";
		for(int i=0; i<s.length(); i++) {
			char lettera = s.charAt(i);
			char letteraconfronto = lettera; //Mi servirà per il confronto
			for(int j=0; j<arrayMinuscole.length; j++) {
				if(lettera == arrayMinuscole[j]) { //Se la lettera contiene una lettera MINUSCOLA
					lettera = arrayMaiuscole[j];  //Prenderà il valore corrispondente MAIUSCOLO
					stringaMaiuscola += lettera;  //Inserisco la lettera dentro la stringa stringaMaiuscola
				}
			} if(lettera == letteraconfronto) { //Se la lettera è uguale al suo valore prima del for
				stringaMaiuscola += lettera;    //(Cioè non è stata resa minuscola, inseriscila)
			}
		}
		return stringaMaiuscola;
	}
	
	//boolean equals(String s1, String s2)
	boolean equals(String s1, String s2) {
		if(s1 == s2) {  //Semplicemente se le stringhe sono uguali torna true
			return true;
		}
		return false;
	}
	
	//boolean equalsIgnoreCase(String s1, String s2)
	public static boolean  equalsIgnoreCase(String s1, String s2) {
		char[] arrayMaiuscole = {'A','B','C','D','E','F','G','H','I','L','M','N','O','P','Q','R','S','T','U','V','Z','X','K','J','Y','W'};
		char[] arrayMinuscole = {'a','b','c','d','e','f','g','h','i','l','m','n','o','p','q','r','s','t','u','v','z','x','k','j','y','w'};
		String isEquals = "";
		
		//Casi predefiniti:		
		//Se le stringhe inserite sono già uguali
		if(s1 == s2) {
			return true;
		}
		
		//Se una stringa è maggiore dell'altra
		if(s1.length() > s2.length() || s2.length() > s1.length()) {
			return false;
		}
		
		for(int i=0; i<s1.length(); i++) {
			char letteras1 = s1.charAt(i); 
			char letteras2 = s2.charAt(i);
			for(int j=0; j<arrayMaiuscole.length; j++) {
				if(letteras1 == arrayMaiuscole[j] || letteras1 == arrayMinuscole[j]) {
					letteras1 = arrayMinuscole[j]; //Rendi minuscola ogni lettera di s1
				}if(letteras2 == arrayMaiuscole[j] || letteras2 == arrayMinuscole[j]) {
					letteras2 = arrayMinuscole[j]; //Rendi minuscola ogni lettera di s2
					if(letteras1 == letteras2) { //Se le lettere sono uguali
						isEquals+=letteras1;	//Inseriscile dentro la stringa isEquals
					} else {
						isEquals = "";  //Altrimenti isEquals torna vuota
						break;			//E viene fermato il ciclo for
					}
				}
			}
		}
		if(isEquals != "") {  //Se isEquals contiene valori (quindi le lettere erano tutte uguali)
			return true;	  //La condizione sarà vera
		}
		return false;
	}
	
	//Meglio in 2 metodi
	//boolean contains(String s, String str)
	public static boolean contains(String s, String str) {
		int j;
		int x = 0;
		boolean trovato = false;
		char letteradx = str.charAt(x);
		if(str.length()>1) { //Se la parola da cercare ha più di una lettera
			for(int i=0; i<s.length(); i++) {
				if(trovato==true) {  //Se la parola è già stata trovata, ferma il ciclo
					break;
				}
				char letterasx = s.charAt(i);
				if(letterasx == letteradx) { //Se la lettera della parola è uguale alla prima lettera da cercare (str.charAt(x) con x = 0)
					x++; //Aumenta x per verificare la lettera successiva della parola da cercare
					letteradx = str.charAt(x); //E ovviamente aggiorna la variabile con la x aumentata
					for(j=i+1; j<s.length(); j++) { //A questo punto usiamo un altro for per scorrere le lettere della parola
						letterasx = s.charAt(j);  //Prendo la lettera della parola
						if(letterasx == letteradx) {  //Se è uguale alla lettera (aggiornata con x++) della parola da cercare
							if(x == str.length()-1) { //Se siamo all'ultima lettera della parola da cercare
								trovato = true;			//Vuol dire che abbiamo trovato la parola e fermiamo il ciclo
								break;
							} else {   //Altrimenti aumentiamo l'indice x per leggere la prossima lettera
								x++;
								letteradx = str.charAt(x);
							}
						} else {  //Se non è stata trovata alcuna lettera uguale, ferma il ciclo e setta IndiceCorrispondente a -1
							x=0;
							letteradx = str.charAt(x);
							trovato = false;
							break;
						}
					}
				}
			}
		} else if(str.length() > s.length()) { //Se la parola da cercare ha più lettera della stringa
			trovato = false;
		} else { //Se la parola da cercare ha 1 sola lettera
			for(int i=0; i<s.length(); i++) {
				char letterasx = s.charAt(i);
				if(letterasx == letteradx){
					trovato = true;
				}
			}
		}

		return trovato;
	}
	
	//boolean startsWith(String s, String prefix)
	public static boolean startsWith(String s, String prefix) {
		int x = 0;
		char prefisso = prefix.charAt(x); //Carattere trasformato in char per fare poi il confronto (sennò str e char non possono confrontarsi)
		if(prefix.length() >= s.length()) { //Se prefisso maggiore o uguale alla stringa torna falso
			return false;
		}
		for(int i=0; i<s.length(); i++) {
			char iniziales = s.charAt(i); //Indice 0 della stringa
			if(iniziales == prefisso) { //Se s[i] == prefix[x]
				if(x<prefix.length()-1) { //E soprattutto se x è al massimo all'ultima sua lettera
					x++;  //Allora aumenta
					prefisso = prefix.charAt(x);  //E setta la variabile per il confronto
				} else { //Altrimenti è >= a prefix.length()-1, cioè l'ultima lettera è uguale, quindi true
					return true;
				}
			} else {  //Se non è uguale blocca il ciclo
				break;
			}
		}
		return false;
	}
	
	//boolean endsWith(String s, String suffix)
	public static boolean endsWith(String s, String suffix) {
		int x = suffix.length()-1;
		char suffisso = suffix.charAt(x); //Carattere trasformato in char per fare poi il confronto (sennò str e char non possono confrontarsi)
		for(int i=s.length()-1; i>0; i--) { //Parto dall'ultima lettera
			char lettera = s.charAt(i);
			if(lettera == suffisso) { //Se lettera == lettera corrente del suffisso
				if(x>0) {  
					x--;  //Considera la lettera precedente del suffisso
					suffisso = suffix.charAt(x);
				} else {
					return true;  //Altrimenti se è la prima lettera del suffisso torna true
				}
			}
		}
		return false;
	}
	
	//String replace(String s, char oldChar, char newChar)
	public static String replace(String s, char oldChar, char newChar) {
		String stringaModificata = "";
		for(int i=0; i<s.length(); i++) {
			char lettera = s.charAt(i);
			if(lettera == oldChar) {
				lettera = newChar;
				stringaModificata += lettera;
			} else {
				stringaModificata += lettera;
			}
		}
		return stringaModificata;
	}
	
	//Meglio in 2 metodi
	//String replace(String s, String oldChar, String newChar)
	public static String replace(String s, String oldChar, String newChar){
    	String stringaModificata = "";
    	int corrispondenza = 1;  //Servirà per vedere se è stata cambiata la lettera (quindi se oldChar presente in s)
    	int x = 0;
    	int k = 0;
    	char letteras = s.charAt(0);
    	char letteraOldChar = oldChar.charAt(x);
    	char letteraNewChar = newChar.charAt(k);
       
    	//Caso particolare
    	//Stringa da cercare maggiore della stringa s
    	if(oldChar.length() > s.length()){
    		return stringaModificata + "Stringa da cercare troppo lunga";
    	}
           
    	//Stringa da cercare maggiore o uguale alla stringa da inserire
    	for(int i=0; i<s.length(); i++){
    		if(letteras == letteraOldChar){
    			letteras = letteraNewChar;
    			stringaModificata+=letteras;
    			if(oldChar.length() == 1){
    				letteras = letteraNewChar;
    				stringaModificata+=letteras;
    			}
    			else{
    				for(int j=i+1; j<s.length(); j++){
    					x++;
    					if(x<oldChar.length()){	//Se non siamo arrivati all'ultima lettera di oldChar
    						letteras = s.charAt(j);
    						letteraOldChar = oldChar.charAt(x);
    						if(letteras == letteraOldChar){
    							k++;
    							letteraNewChar = newChar.charAt(k);
    							letteras = letteraNewChar;
    							stringaModificata+=letteras;
    						} else {
    							corrispondenza = 0;
    						}
    					} else {
    						if(k<newChar.length() && corrispondenza != 0) { //Se non siamo arrivati all'ultima lettera di newChar
    							k++;
    							letteraNewChar = newChar.charAt(k);
    							letteras = letteraNewChar;
    							stringaModificata+=letteras;
    						}
    						letteras = s.charAt(j);
    						stringaModificata+=letteras;
    						k++;
    					}
    				}
    			}
    		}
    	} if(corrispondenza == 0){
    		return stringaModificata="Nessuna corrispondenza trovata";
    	}
    	return stringaModificata;
    }
	
	//String trim(String s)
	public static String trim(String s) {
		String stringaSenzaSpazi = "";
		for(int i=0; i<s.length(); i++) {
			char lettera = s.charAt(i);
			if(lettera != ' ') {
				stringaSenzaSpazi += lettera;
			}
		}
		return stringaSenzaSpazi;
	}
	
	public static void main(String[] args) {
		String risultato;
		boolean risultatoBooleano;
		//risultato = StringUtils.indexOf("animals",'s');
		//risultato = StringUtils.indexOf("animals", 'a', 0);
		//risultato = StringUtils.indexOf("animalsal", "al");
		//risultato = StringUtils.indexOf("animalsal", "a", 2);
		//risultato = StringUtils.substring("animals", 3);
		//risultato = StringUtils.substring("animals", 3, 7);
		//risultato = StringUtils.toLowerCase("PrOvA");
		//risultato = StringUtils.toUpperCase("PrOvA");
		//risultatoBooleano = StringUtils.equals("ciao","ciao");
		//risultatoBooleano = StringUtils.equalsIgnoreCase("ciAoc","cIAoC");
		//risultatoBooleano = StringUtils.contains("ciaouauio","ou");
		//risultatoBooleano = StringUtils.startsWith("ciao", "ci");
		//risultatoBooleano = StringUtils.endsWith("ciao", "iao");
		//risultato = StringUtils.replace("animals", 'a', 'k');
		//risultato = StringUtils.replace("animals", "an", "ked");
		//risultato = StringUtils.trim("An i m al  s");
		
		//System.out.println(risultato);
		//System.out.println(risultatoBooleano);
	}

}