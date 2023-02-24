package it.beije.neumann.web.vanoli.rubricaWeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.beije.neumann.web.vanoli.rubricaWeb.Contatto;
import it.beije.neumann.web.vanoli.rubricaWeb.JPAEntityFactory;



public class RubricaJPAWeb{
	
	public static List<Contatto> LoadRubricaFromDB() {		
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root);
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public static void WriteRubricaToDB(List<Contatto> listaContatti) {
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
	public static List<Contatto> elencoRubrica(String orderBy) {				
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root).orderBy(cb.asc(root.get(orderBy)));
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public static List<Contatto> cercaContatto(String nome, String cognome) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root).where(cb.and(cb.equal(root.get("nome"), nome), 
									 cb.equal(root.get("cognome"), cognome)));
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public static Contatto findContattoById(int id) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
		Root<Contatto> root = cr.from(Contatto.class);
		cr.select(root).where(cb.equal(root.get("id"), id));
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti.get(0);
	}
	
	public static void inserisciContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();		
		c.setId(0);
		entityManager.persist(c);		
		transaction.commit();
		entityManager.close();
	}
	
	public static void editContatto(Contatto newC) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Contatto> criteriaUpdate = cb.createCriteriaUpdate(Contatto.class);
		Root<Contatto> root = criteriaUpdate.from(Contatto.class);
		criteriaUpdate.set("nome", newC.getNome());
		criteriaUpdate.set("cognome", newC.getCognome());
		criteriaUpdate.set("telefono", newC.getTelefono());
		criteriaUpdate.set("email", newC.getEmail());
		criteriaUpdate.set("note", newC.getNote());
		criteriaUpdate.where(cb.equal(root.get("id"), newC.getId()));

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createQuery(criteriaUpdate).executeUpdate();
		transaction.commit();		
		entityManager.close();
	}
	
	public static void deleteContatto(Contatto c) {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Contatto> criteriaDelete = cb.createCriteriaDelete(Contatto.class);
		Root<Contatto> root = criteriaDelete.from(Contatto.class);
		criteriaDelete.where(cb.equal(root.get("id"), c.getId()));

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createQuery(criteriaDelete).executeUpdate();
		transaction.commit();
		entityManager.close();
	}
	
	public static List<Contatto> trovaContattiDuplicati() {
		EntityManager entityManager = JPAEntityFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);		
		Root<Contatto> root = cr.from(Contatto.class);
		
		Subquery<Contatto> subcr = cr.subquery(Contatto.class);
		Root<Contatto> subroot = subcr.from(Contatto.class);
		subcr.select(subroot).where(cb.and(cb.equal(root.get("nome"), subroot.get("nome")),
										   cb.equal(root.get("cognome"), subroot.get("cognome")),
										   cb.notEqual(root.get("id"), subroot.get("id"))));
		
		cr.select(root).where(cb.exists(subcr));
		
		Query query = entityManager.createQuery(cr);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}

	public static void unisciContattiDuplicati() {
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
	
	private static String unisciStringhe(String s1, String s2) {
		if (s1.equals(""))
			return s2;
		else if (s2.equals(""))
			return s1;
		else if (s1.equals(s2))
			return s1;
		else
			return s1 + "; " + s2;
	}
	
	public static void main (String[] args) {
		System.out.println(elencoRubrica("id"));
	}
}
