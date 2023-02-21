package it.beije.neumann.rubrica;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RubricaJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//INSERT
		Contatto contatto = new Contatto();
//		contatto.setId(9);
//		contatto.setName("Paride");
//		contatto.setSurname("Gialli");
//		contatto.setEmail("paride@giallo.it");
//		
//		System.out.println("contatto PRE : " + contatto);
//		entityManager.persist(contatto);
//		System.out.println("contatto POST : " + contatto);

		//SELECT JPQL
//		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
//		List<Contatto> contatti = query.getResultList();
////		for (Contatto c : contatti) {
////			System.out.println(c);
////		}
//		System.out.println(contatti);
		
		contatto = entityManager.find(Contatto.class, 1);
		System.out.println(contatto);

		//UPDATE
//		contatto = contatti.get(contatti.size()-1);
		//contatto.setId(9);
//		contatto.setName("Youness");
//		contatto.setSurname("Verde");
//		contatto.setEmail("youness@verde.it");
//
//		System.out.println("contatto PRE : " + contatto);
//		entityManager.persist(contatto);
//		System.out.println("contatto POST : " + contatto);

		//DELETE
//		entityManager.remove(contatto);
		
		transaction.commit();
		//transaction.rollback();

		entityManager.close();
	}

}
