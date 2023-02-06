package it.beije.xvi.cap5.nido_vanoli_vellani;

public abstract class MezzoDiTrasporto {

	private int capacità;

	public int getCapacità() {
		return capacità;
	}

	public void setCapacità(int capacità) {
		this.capacità = capacità;
	}

	public void rallenta() {
		System.out.println("Sto rallentando...");
	}

	public void accelera() {
		System.out.println("Sto accelerando...");
	}

	public abstract void info();

}
