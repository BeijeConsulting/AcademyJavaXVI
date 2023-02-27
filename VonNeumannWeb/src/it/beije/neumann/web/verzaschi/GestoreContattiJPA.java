package it.beije.neumann.web.verzaschi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;








public class GestoreContattiJPA 
{

	public static List<Contact> vediListaContatti()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
	
		
		
		Query query = entityManager.createQuery("SELECT c FROM Contact as c");
		List<Contact> contatti = query.getResultList();
		
	
		
		
		return contatti;
		
		
	}
	
	public static List<Contact> cancellaContatto(String nome, String cognome)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
       List<Contact> contatti=vediListaContatti();
       List<Contact> eliminati=new ArrayList<>();
		
		
		for(Contact c : contatti)
		{
			if(c.getName().equals(nome))
			{
				if(c.getSurname().equals(cognome)) {
					entityManager.remove(entityManager.contains(c) ? c : entityManager.merge(c));
					eliminati.add(c);
				}
					
				
			}
		}
		
		
		transaction.commit();
		entityManager.close();
	
		return eliminati;
		
		
		
	}
	
	public static void addContact(Contact c) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(c);
		
		transaction.commit();
		entityManager.close();
		
	}
	
	public static List<Contact> vediListaDuplicati()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Contact> contatti= vediListaContatti();
		List<Contact> duplicati=new ArrayList<>();
		int conta=1;
		for(Contact c : contatti)
		{
			
			for(int i=conta; i<contatti.size();i++)
			{
				if(c.getName().equals(contatti.get(i).getName()))
				{
					if(c.getSurname().equals(contatti.get(i).getSurname())) {
						duplicati.add(contatti.get(i));
						duplicati.add(c);
					}
				}
				
			}
			conta++;
		}
		
		
		transaction.commit();
		em.close();
		
		return duplicati;
	}
	
	public static void main(String [] args)
	{
		System.out.println(vediListaContatti());
	}

}
