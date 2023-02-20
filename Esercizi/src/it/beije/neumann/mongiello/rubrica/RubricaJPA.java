package it.beije.neumann.mongiello.rubrica;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;



public class RubricaJPA {
	
	
	
	public void stampaDb(){
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();
		
	}

	public void inserisciContatto(Contatto contatto) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
	}

	public void editContatto(int id, String fieldToEdit, String newField) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto contatto = entityManager.find(Contatto.class, id);
		
		switch( fieldToEdit ) {
		case "cognome":
			contatto.setSurname(newField);
			break;
		case "nome":
			contatto.setName(newField);
			break;
		case "telefono":
			contatto.setTelephone(newField);
			break;
		case "email":
			contatto.setEmail(newField);
			break;
		case "note":
			contatto.setNote(newField);
			break;
		}
		transaction.commit();
		entityManager.close();
		
	}

	public void deleteContact(int id) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto contatto = entityManager.find(Contatto.class, id);
		entityManager.remove(contatto);
		transaction.commit();
		entityManager.close();
		
	}

	public void order(String valore) {
//		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
//		StringBuilder queryStr = new StringBuilder("SELECT c FROM Contatto c order by " );
//		queryStr.append(valore);
//		Query query = entityManager.createQuery(queryStr.toString());
//		List<Contatto> contatti = query.getResultList();
//		Contatto.stampaRubrica(contatti);
//		entityManager.close();
		
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto c");
		List<Contatto> contatti = query.getResultList();
		if( valore.toLowerCase().equals("nome")) {
			RubricaJPA.orderByName(contatti);
			Contatto.stampaRubrica(contatti);
		}else if( valore.toLowerCase().equals("cognome") ) {
			RubricaJPA.orderBySurname(contatti);
			Contatto.stampaRubrica(contatti);
		}
		
		
		entityManager.close();
		
	}
	
	public static void orderByName(List<Contatto> listaContatti) {
		Collections.sort(listaContatti, new Comparator<Contatto>() {
			@Override
			public int compare(Contatto c1, Contatto c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
	}
	
	public static void orderBySurname(List<Contatto> listaContatti) {
		Collections.sort(listaContatti, new Comparator<Contatto>() {
			@Override
			public int compare(Contatto c1, Contatto c2) {
				return c1.getSurname().compareTo(c2.getSurname());
			}
		});
	}

	public void search(String surname) {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Contatto c WHERE cognome = :c");
		query.setParameter("c", surname);
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();
		
	}

	public void duplicate() {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT c2 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)");
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		entityManager.close();
		 
	}
	
	
	

	public void importXml() throws ParserConfigurationException, SAXException, IOException {
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		File file = new File("/temp/import.xml");
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);

		Element rootElement = document.getDocumentElement();		
		List<Element> elements = RubricaXml.getChildElements(rootElement);


		for (Element el : elements) {
			Contatto c = new Contatto();
			transaction.begin();
			List<Element> values = RubricaXml.getChildElements(el);
			for (Element v : values) {			
				switch (v.getNodeName()) {
				case "ID":
					c.setId(0);
					break;
				case "SURNAME":
					c.setSurname(v.getTextContent());
					break;
				case "NAME":
					c.setName(v.getTextContent());
					break;
				case "TELEPHONE":
					c.setTelephone(v.getTextContent());
					break;
				case "EMAIL":
					c.setEmail(v.getTextContent());
					break;
				case "NOTE":
					c.setNote(v.getTextContent());
					break;
				}
				
			}
			
			
			entityManager.persist(c);
			transaction.commit();
		}
		
		entityManager.close();
	}

}
