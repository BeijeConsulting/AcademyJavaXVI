package it.beije.neumann.iaria.esercizi_array;

public class VerificaCrescente {
	
    public boolean isCrescente(int[] array){
        int k;
        for(int i=0; i<array.length; i++){
            k = array[i+1];
            if(array[i]<k){
                return true;
            } else{
                return false;
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        int[] array = {1,4,10,21,39,42};
        VerificaCrescente verifica = new VerificaCrescente();
        boolean esito = verifica.isCrescente(array);
        System.out.println(esito);
    }

}