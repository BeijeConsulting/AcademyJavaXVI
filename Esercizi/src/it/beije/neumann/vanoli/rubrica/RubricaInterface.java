package it.beije.neumann.vanoli.rubrica;

import java.util.List;

public interface RubricaInterface {
	List<Contatto> LoadRubricaFromDB();
	void WriteRubricaToDB(List<Contatto> listaContatti);
	List<Contatto> elencoRubrica(String orderBy);
	List<Contatto> cercaContatto(String nome, String cognome);
	void inserisciContatto(Contatto c);
	void editContatto(Contatto c);
	void deleteContatto(Contatto c);
	List<Contatto> trovaContattiDuplicati();
	//List<Contatto> unisciContattiDuplicati();
}
