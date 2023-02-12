package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class ShadesOfGrey {
	
	static String checkNumber(int x) {
		String letteraCorrispondente = "";
		
		switch(x) {
			case 10:
				letteraCorrispondente = "a";
				break;
			case 11:
				letteraCorrispondente = "b";
				break;
			case 12:
				letteraCorrispondente = "c";
				break;
			case 13:
				letteraCorrispondente = "d";
				break;
			case 14:
				letteraCorrispondente = "e";
				break;
			case 15:
				letteraCorrispondente = "f";
				break;
		}
		
		return letteraCorrispondente;
	}
	
    static String[] shadesOfGrey(int num){
        String[] arrayGrey = new String[num+1];
        int divisione = 0;
        String esadecimale = "";
       
        if(num<0){
            System.out.print("Array nullo: ");
        } else {
        	for(int i=0; i<=num; i++) {
        		for(int j=1; j<=3; j++) {
        			divisione = i/16;
        			
        			if(divisione > 9) { //Se il numero è maggiore di 9 verifica la lettera corrispondente
        				esadecimale += checkNumber(divisione); //Verifica tramite chiamata al metodo
        			} else {
        				esadecimale += divisione; //Concateno una stringa per poi inserirla nell'array
        			}
        			
        			if(i%16 > 9) { //Se il numero è maggiore di 9 verifica la lettera corrispondente
        				esadecimale += checkNumber(i%16); //Verifica tramite chiamata al metodo
        			} else {
        				esadecimale += i%16; //Concateno una stringa per poi inserirla nell'array
        			}
        			
        		}
        		
        		if(i>255) {
        			break;
        		} else {
        			arrayGrey[i] = (esadecimale);
        		}
        		
        		esadecimale = ""; //Reset risultato esadecimale
        	}
        }
       
        return arrayGrey;
    }

	public static void main(String[] args) {
		String[] arrayColorGrey = shadesOfGrey(260);
        for(int i=0; i<arrayColorGrey.length; i++){
        	if(i<256) {
        		System.out.println("rgb("+i+","+i+","+i+") = "+arrayColorGrey[i]);
        	}
        }
	}

}
