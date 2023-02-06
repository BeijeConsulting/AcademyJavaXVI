package it.beije.xvi.cap5.elassl_iaria_mongiello;

public class Lancia extends Getto {
	boolean lanciata = false;
	
	public void lancioSingolo() {
		if( !lanciata ) {
			System.out.println("Lanciata");
			lanciata = true;
		}else {
			System.out.println("Riprendi prima l'arma");
		}
	}
	
	public void ricarica() {
		System.out.println("Pronta per essere utilizzata");
		lanciata = false;
	}
	
	public void prendi() {
		System.out.println("Lancia presa");
	}

	@Override
	public void ricarica(int colpi) {
		ricarica();
		
	}
	
}
