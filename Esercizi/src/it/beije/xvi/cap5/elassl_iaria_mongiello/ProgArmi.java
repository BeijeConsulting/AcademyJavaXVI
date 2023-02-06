package it.beije.xvi.cap5.elassl_iaria_mongiello;

public class ProgArmi {

	public static void main(String[] args) {
		Fucile m1 = new Fucile(10);
		Lancia l1 = new Lancia();
		
		m1.prendi();
		m1.colpoSingolo();
		m1.colpoSingolo();
		m1.ricarica(2);
		m1.riponi();
		System.out.println();
		
		l1.prendi();
		l1.lancioSingolo();
		l1.ricarica();
		l1.riponi();
		

	}

}
