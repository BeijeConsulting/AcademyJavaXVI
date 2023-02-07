package it.beije.neumann.iaria.esercizi_array;

public class MediaMultiploDiTre {

    public static void main(String[] args) {
        int[] array = {1,3,15,21,39,40,21,3};
        int k = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]%3==0){
                k += array[i];
            }
        }
        System.out.println(k/2);
    }


}
