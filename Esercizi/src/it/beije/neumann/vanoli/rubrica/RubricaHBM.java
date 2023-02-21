package it.beije.neumann.vanoli.rubrica;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RubricaHBM implements RubricaInterface {
	
	public List<Contatto> LoadRubricaFromDB() {		
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}

	public void WriteRubricaToDB(List<Contatto> listaContatti) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();		
		for (Contatto c: listaContatti) {				
			session.save(c);
		}
		transaction.commit();
	}
	
	//funzioni riga di comando	
	public List<Contatto> elencoRubrica(String orderBy) {				
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c ORDER BY " + orderBy);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public List<Contatto> cercaContatto(String nome, String cognome) {
		Session session = HBMsessionFactory.openSession();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE nome = :param1 AND cognome = :param2");
		query.setParameter("param1", nome);
		query.setParameter("param2", cognome);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public void inserisciContatto(Contatto c) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();		
		session.save(c);
		transaction.commit();
	}
	
	public void editContatto(Contatto newC) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", newC.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		Contatto oldC = contatti.get(0);
		oldC.setNome(newC.getNome());
		oldC.setCognome(newC.getCognome());
		oldC.setTelefono(newC.getTelefono());
		oldC.setEmail(newC.getEmail());
		oldC.setNote(newC.getNote());
		session.save(oldC);
		transaction.commit();
	}
	
	public void deleteContatto(Contatto c) {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", c.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		session.delete(contatti.get(0));
		transaction.commit();
	}
	
	public List<Contatto> trovaContattiDuplicati() {
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.nome = c1.nome AND c2.cognome = c1.cognome AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();		
		return contatti;		
	}
	
	public void unisciContattiDuplicati() {
		List<Contatto> dupes = trovaContattiDuplicati();
		List<Contatto> toEdit = new ArrayList<Contatto>();
		for (Contatto dup: dupes) {
			//Controlliamo se abbbiamo già inserito il contatto nella lista toEdit, se si' ci salviamo il contatto altrimenti resta null
			Contatto trovatoEdit = null;
			for (Contatto c: toEdit) {
				if (c.getNome().equals(dup.getNome()) && c.getNome().equals(dup.getNome())) {
					trovatoEdit = c;
					break;
				}
			}
			if (trovatoEdit == null) {
				//se non l'abbiamo trovato, lo aggiungiamo semplicemente nella lista
				toEdit.add(dup);
			}
			else {
				//altrimenti, lo uniamo con quello che abbiamo trovatoEdit e facciamo una delete
				trovatoEdit.setEmail(unisciStringhe(trovatoEdit.getEmail(), dup.getEmail()));
				trovatoEdit.setTelefono(unisciStringhe(trovatoEdit.getTelefono(), dup.getTelefono()));
				trovatoEdit.setNote(unisciStringhe(trovatoEdit.getNote(), dup.getNote()));
				deleteContatto(dup);
			}
		}
		//adesso andiamo semplicemente a modificare i contatti che abbiamo in toEdit
		for (Contatto c: toEdit) {
			editContatto(c);
		}
	}
	
	private String unisciStringhe(String s1, String s2) {
		if (s1.equals(""))
			return s2;
		else if (s2.equals(""))
			return s1;
		else if (s1.equals(s2))
			return s1;
		else
			return s1 + "; " + s2;
	}
	
}
