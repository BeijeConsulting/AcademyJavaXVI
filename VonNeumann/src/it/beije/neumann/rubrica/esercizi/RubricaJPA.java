package it.beije.neumann.rubrica.esercizi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.neumann.rubrica.Contatto;

public class RubricaJPA {
	static public void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Contatto contatto = new Contatto();

		//SELECT JPQL
//		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
//		List<Contatto> contatti = query.getResultList();
//		for (Contatto c : contatti) {
//			System.out.println(c);
//		}
//		System.out.println(contatti);
		
		contatto = entityManager.find(Contatto.class, 2);
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
		
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("1)Vedi lista contatti");
		System.out.println("2)Cerca contatto");
		System.out.println("3)Inserisci nuovo contatto");
		System.out.println("4)Modifica contatto");
		System.out.println("5)Cancella contatto");
		System.out.println("6)Trova contatti duplicati");
		System.out.println("7)Unisci contatti duplicati");
		
		String st = s.next();
		while (!st.equalsIgnoreCase("exit")) {
			switch(st) {
			 case "1":
				 getContacts(entityManagerFactory);
				break;
			 case "2":
				 searchContact(entityManagerFactory);
				 break;
			 case "3":
				 addContact(entityManagerFactory);
				 break;
			 case "4":	
//				 updateContact(statement);
				 break;
			 case "5":
				 deleteContact(entityManagerFactory);
				 break;
			 case "6":
				 printDuplicate();
				 break;
			 case "7":
				 mergeDuplicate();
				 break;
			default:
				System.out.println("Numero non valido");
			}
			st = s.next();
			
		}
		s.close();
	}
	
	public static List<Contatto> getContacts(EntityManagerFactory entityManagerFactory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		System.out.println(contatti);
		entityManager.close();
		return contatti;
	}
	
	public static void searchContact(EntityManagerFactory entityManagerFactory) {
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci l'id del contatto");
	    String id = s.next();
	    int i = Integer.parseInt(id);
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
		Contatto contatto = entityManager.find(Contatto.class, i);
		System.out.println(contatto);
		entityManager.close();
	}
	public static void addContact(EntityManagerFactory entityManagerFactory) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci il nome: ");
	    String name = s.next();
	    System.out.println("Inserisci il Cognome: ");
	    String surname = s.next();
	    System.out.println("Inserisci telefono: ");
	    String phone = s.next();
	    System.out.println("Inserisci email: ");
	    String email = s.next();
	    System.out.println("Inserisci note: ");
	    String note = s.next();
	    
	    Contatto contatto = new Contatto();
		contatto.setName(name);
		contatto.setSurname(surname);
		contatto.setEmail(email);
		contatto.setNote(note);
		contatto.setTelephone(phone);
		entityManager.persist(contatto);
		
		transaction.commit();
		entityManager.close();
		System.out.println(contatto);
	}
	public static void updateContact(Statement statement) {
		int rows;
		try {
			rows = statement.executeUpdate("UPDATE contatti SET note = 'Siamo Bianchi' WHERE id = '1'");
			System.out.println("rows updated : " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void deleteContact(EntityManagerFactory entityManagerFactory) {
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci l'id del contatto da eliminare");
	    String id = s.next();
	    int i = Integer.parseInt(id);
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto contatto = entityManager.find(Contatto.class, i);
		entityManager.remove(contatto);
		transaction.commit();
		entityManager.close();
		System.out.println("Contatto eliminato: " + contatto);
	}
	public static void printDuplicate() {
		System.out.println("printDuplicate");
	}
	public static void mergeDuplicate() {
		System.out.println("mergeDuplicate");
	}
	
	
	
	public static void exportOnCsv(List<Contatto> contacts){
		List<String> rows = new ArrayList<String>();
		for(Contatto c : contacts) {
			StringBuilder str = new StringBuilder();
			str.append(c.getId()).append(",");
			str.append(c.getName()).append(",");
			str.append(c.getSurname()).append(",");
			str.append(c.getEmail()).append(",");
			str.append(c.getTelephone()).append(",");
			str.append(c.getNote()).append(",");
			
			rows.add(str.toString());
		}
		CSVmanager.writeCsv(rows, "./src/it/beije/neumann/rubrica/esercizi/nuovaRubrica.csv");
	}
	
}
