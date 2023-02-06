package it.beije.xvi.cap5.elassl_iaria_mongiello;

public abstract class Fuoco extends Armi implements Ricaricabile, LungoRaggio {
	
	public  void riponi() {
		System.out.println("Arma riposta e scaricata");
	}

	public abstract void ricarica(int proiettili);
	
}
