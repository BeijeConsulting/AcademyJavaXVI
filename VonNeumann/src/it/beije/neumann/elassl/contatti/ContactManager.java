package it.beije.neumann.elassl.contatti;

import java.util.List;

import it.beije.neumann.rubrica.Contatto;

public interface ContactManager {
	public List<Contatto> getContatti() throws ClassNotFoundException;
	public int writeContatto(Contatto contatto) throws ClassNotFoundException;
	public int updateContatto(Contatto contact) throws ClassNotFoundException;
	public List<Contatto> getDuplicates() throws ClassNotFoundException;
	public void mergeDuplicates() throws ClassNotFoundException;
	public int deleteContatto(Contatto contact) throws ClassNotFoundException;
}
