package it.beije.neumann.vanoli.rubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RubricaJPA implements RubricaInterface{
	
	public List<Contatto> LoadRubricaFromDB() {		
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public void WriteRubricaToDB(List<Contatto> listaContatti) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		for (Contatto c: listaContatti) {
			c.setId(0);
			entityManager.persist(c);
		}
		transaction.commit();
		entityManager.close();
	}
	
	//funzioni riga di comando	
	public List<Contatto> elencoRubrica(String orderBy) {				
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY " + orderBy);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public List<Contatto> cercaContatto(String nome, String cognome) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE nome = :param1 AND cognome = :param2");
		query.setParameter("param1", nome);
		query.setParameter("param2", cognome);
		List<Contatto> contatti = query.getResultList();	
		return contatti;
	}
	
	public void inserisciContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();		
		c.setId(0);
		entityManager.persist(c);		
		transaction.commit();
		entityManager.close();
	}
	
	public void editContatto(Contatto newC) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
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
		entityManager.persist(oldC);
		transaction.commit();
		entityManager.close();
	}
	
	public void deleteContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c WHERE id = :param1");
		query.setParameter("param1", c.getId());
		List<Contatto> contatti = query.getResultList();
		if (contatti.size() != 1) {
			throw new RuntimeException("Il DB si è rotto...");
		}
		entityManager.remove(contatti.get(0));
		transaction.commit();
		entityManager.close();
	}
	
	public List<Contatto> trovaContattiDuplicati() {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.nome = c1.nome AND c2.cognome = c1.cognome AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
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
