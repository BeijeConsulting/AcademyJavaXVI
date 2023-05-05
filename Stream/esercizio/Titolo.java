package esercizio;

import java.util.ArrayList;
import java.util.List;

public class Titolo {
	

	public enum Allineamento {
		CX, SX, DX
	}
	
	private Allineamento allineamento;
	
	private List<Riga> righe;

	public Titolo(Allineamento a) {
		this(a, new ArrayList<>());
	}

	public Titolo(Allineamento a, List<Riga> righe) {
		allineamento = a;
		this.righe = righe;
	}

	public void add(Riga r) {
		righe.add(r);
	}

	public boolean isCentered() {
		return allineamento == Allineamento.CX;
	}

	@Override
	public String toString() {
		return righe.toString();
	}

	public Allineamento getAllineamento() {
		return allineamento;
	}

	public List<Riga> getRighe() {
		return new ArrayList<>(righe);
	}

	
}
