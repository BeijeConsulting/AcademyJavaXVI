package it.beije.neumann.web.elassl.contatti;

import java.util.List;

public interface ContactManager {
	public List<Contatto> getContatti() throws ClassNotFoundException;
	public int writeContatto(Contatto contact) throws ClassNotFoundException;
	public int updateContatto(Contatto contact) throws ClassNotFoundException;
	public List<Contatto> getDuplicates() throws ClassNotFoundException;
	public void mergeDuplicates() throws ClassNotFoundException;
	public int deleteContatto(Contatto contact) throws ClassNotFoundException;	
	public List<Contatto> getContatto(Contatto contact);

}
