package it.beije.xvi.cap5.nido_vanoli_vellani;

public interface MezzoPubblico {
	public default void carico() {
		System.out.println("Salgono i passeggeri");
	}

	public default void scarico() {
		System.out.println("Scendono i passeggeri");
	}
}
