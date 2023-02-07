package it.beije.neumann.iaria.esercizi_array;

public class Ricorrente {

    public int mostRecurrent(int[] array){
        int ValRicorrente = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] == array[j]){
                    count1++;
                    ValRicorrente = array[i];
                }
            }
            if(count1>count2){
                count2 = count1;
                count1 = 0;
            }
        }
        return ValRicorrente;
    }
    
    public static void main(String[] args) {
        int[] array = {1,10,4,21,39,42,4,10,4,10,10,23,21};
        Ricorrente NumRicorrente = new Ricorrente();
        System.out.println(NumRicorrente.mostRecurrent(array));
    }

}