package it.beije.neumann.iaria.esercizi_cicli;

public class Fibonacci2 {

	public static void main (String[] args){
		String sequenza = "";
		long x,j,k;
		x = 1;
		j = 1;
		for(int i=1; i<100; i++){
			if(i == 1) {
				sequenza+=x;
				System.out.print(sequenza);
			} else if(i == 2) {
				sequenza = sequenza+","+j;
				System.out.println();
				System.out.print(sequenza);
			} else {
				System.out.println();
				k = x + j;
				sequenza = sequenza+","+k;
				System.out.print(sequenza);
				x = j;
				j = k;
			}
		}
	}

}
