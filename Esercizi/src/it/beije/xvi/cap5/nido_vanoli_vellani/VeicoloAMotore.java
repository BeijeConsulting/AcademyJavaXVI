package it.beije.xvi.cap5.nido_vanoli_vellani;

public interface VeicoloAMotore {

	public default void accendi() {
		System.out.println("Accensione");
	}

	public default void spegni() {
		System.out.println("Spegnimento");
	}
}
