package it.beije.neumann.iaria.esercizi_array;

public class Media {

    public static void main(String[] args) {
        int[] array = {1,3,15,21,39,40,21,4,9,10};
        int somma = 0;
        for(int i=0; i<array.length; i++){
            somma+=array[i];
        }
        System.out.println(somma/2);
    }

}
