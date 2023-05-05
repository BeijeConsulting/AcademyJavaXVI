package esercizio;

public class Riga {
	private String riga;
	private int numero;

	public Riga(String riga, int numero) {
		this.riga = riga;
		this.numero = numero;
	}

	public Riga(String riga) {
		this(riga, -1);
	}

	@Override
	public String toString() {
		return (numero == -1 ? "" : numero + ": ") + riga;
	}
}
