package it.beije.neumann.web.esercizi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class Rubrica {
//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
//	public static void main(String[] args) {
//		getContacts();
//	}
	
	public static List<Contatto> getContacts() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
public static void addContact(Contatto contact) {
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(contact);
		transaction.commit();
		entityManager.close();
	}

public static Contatto searchContact(String id) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    int i = Integer.parseInt(id);
	Contatto contatto = entityManager.find(Contatto.class, i);
	System.out.println(contatto);
	entityManager.close();
	return contatto;
}

 	public static void updateContact(Contatto c) {
 		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
 	    EntityManager entityManager = entityManagerFactory.createEntityManager();
 	    EntityTransaction transaction = entityManager.getTransaction();
 	    transaction.begin();
 		entityManager.merge(c);
 		transaction.commit();
		entityManager.close();
 	}
}