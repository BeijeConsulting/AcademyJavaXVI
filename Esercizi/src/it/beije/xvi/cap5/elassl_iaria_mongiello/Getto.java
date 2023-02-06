package it.beije.xvi.cap5.elassl_iaria_mongiello;

public abstract class Getto extends Armi implements Ricaricabile, Manuale{

	@Override
	public void colpoSingolo() {
		System.out.println("splaff");
		
	}
	
	public abstract void ricarica(int colpi);
	
}
