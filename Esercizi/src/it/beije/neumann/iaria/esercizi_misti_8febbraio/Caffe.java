package it.beije.neumann.iaria.esercizi_misti_8febbraio;

public class Caffe {
	
	public void caffeina(int n){
        if(n%3==0){
            if(n%2==0){
                System.out.println("Script");
            } else {
               System.out.println("Java");
            }
        } else if(n%3==0 && n%4==0){
            if(n%2==0){
                System.out.println("Script");
            } else {
               System.out.println("Coffee");
            }
        } else{
            System.out.println("match_missed!");
        }
    }

	public static void main(String[] args) {
		Caffe caffe = new Caffe();
		caffe.caffeina(3);

	}

}
