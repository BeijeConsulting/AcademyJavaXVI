package it.beije.neumann.iaria.esercizi_array;

public class StampaZigZag {

    public static void main(String[] args) {
        int[] array = {1,3,15,21,39,40,21,4,9,10};
        for(int i=0; i<array.length-1-i; i++){
            System.out.println(array[i]);
            System.out.println(array[array.length-1-i]);
        }
    }

}
