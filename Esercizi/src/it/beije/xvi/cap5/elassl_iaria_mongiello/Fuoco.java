package it.beije.xvi.cap5.elassl_iaria_mongiello;

public abstract class Fuoco extends Armi implements Ricaricabile, LungoRaggio {
	private int munizioni;
	
	public int getMunizioni() {
		return munizioni;
	}

	public void setMunizioni(int munizioni) {
		this.munizioni = munizioni;
	}
	
	public  void riponi() {
		System.out.println("Arma riposta e scaricata");
	}
	
}
