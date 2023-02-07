package it.beije.xvi.cap5.nido_vanoli_vellani;

public abstract class MezzoDiTrasporto {

	private int capacita;

	public int getCapacita() {
		return capacita;
	}

	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}

	public void rallenta() {
		System.out.println("Sto rallentando...");
	}

	public void accelera() {
		System.out.println("Sto accelerando...");
	}

	public abstract void info();

}
