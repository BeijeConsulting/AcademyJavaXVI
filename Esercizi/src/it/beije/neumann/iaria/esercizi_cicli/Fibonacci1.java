package it.beije.neumann.iaria.esercizi_cicli;

public class Fibonacci1{
	public static int i;
	public static long k,x,j;
	public static void main (String[] args){
		x = 1;
		j = 1;
		System.out.println(x);
		System.out.println(j);
		for(i=2; i<100; i++){
			k = x + j;
			System.out.println(k);
			x = j;
			j = k;
		}
	}
}