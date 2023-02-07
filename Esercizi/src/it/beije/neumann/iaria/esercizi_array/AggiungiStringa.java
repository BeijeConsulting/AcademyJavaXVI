package it.beije.neumann.iaria.esercizi_array;

public class AggiungiStringa {

    public String [] addString(String s, String[] a){
        String[] ArrayIdentico = new String[a.length+1];
        for(int i=0; i<ArrayIdentico.length; i++){
            if(i == ArrayIdentico.length-1){
                ArrayIdentico[ArrayIdentico.length-1] = s;
            } else{
                ArrayIdentico[i] = a[i];
            }
        }
        return ArrayIdentico;
    }
    
    public static void main(String[] args) {
        String[] array = {"parola1","parola2","parola3"};
        AggiungiStringa AggStringa = new AggiungiStringa();
        String[] ArrayCopia = AggStringa.addString("prova",array);
        for(int i=0; i<ArrayCopia.length; i++){
            System.out.println(ArrayCopia[i]);
        }
    }
}