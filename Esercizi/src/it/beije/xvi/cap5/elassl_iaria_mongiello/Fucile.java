package it.beije.xvi.cap5.elassl_iaria_mongiello;

public class Fucile extends Fuoco implements  Manuale {

	int munizioni;
	int gittata = 3;
	
	public Fucile(int munizioni) {
		this.munizioni = munizioni;
	}
	
	@Override
	public void ricarica(int proiettili) {
		System.out.println("Fucile ricaricato");
		munizioni += proiettili;
		}
		
	@Override
	public void getGittata() {
		System.out.println(gittata);	
	}
	@Override
	public void colpoSingolo() {		
		if(munizioni > 0) {
			System.out.println("tu");
			munizioni--;
		}else {
			System.out.println("Fucile scarico, devi ricaricare altrimenti muori veloooooooooce");
		}
	}

	@Override
	public void prendi() {
		System.out.println("Fucile impugnato");
		
	}

	
}
