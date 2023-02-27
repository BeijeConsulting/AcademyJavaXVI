package nicole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.beije.neumann.rubrica.*;

public class GestoreDiContattoJPA 
{
	
	public static List<Contatto> vediListaContatti()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
	
		transaction.commit();
		
		return contatti;
		
		
	}
	
	public static void cercaContatto()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		

		
	
		System.out.print("Avvio Scanner... ");
		Scanner s=new Scanner(System.in);
		String st=s.next();
		String nomeContatto = null;
		String cognomeContatto = null;
		
	while(!st.equalsIgnoreCase("exit"))
	{
	
		System.out.print("Inserisci nome contatto: ");
		nomeContatto=s.next();
		
		System.out.println("Inserisci cognome contatto : ");
		cognomeContatto=s.next();
		break;
	}	
	s.close();
	
	Query query = em.createQuery("SELECT c FROM Contatto as c WHERE c.name LIKE :nomeContatto AND c.surname LIKE :cognomeContatto  ");
	
	
	query.setParameter("nomeContatto", nomeContatto);
	query.setParameter("cognomeContatto", cognomeContatto);
	List<Contatto> contatti = query.getResultList();
	System.out.println(contatti);
	
	
	transaction.commit();
	em.close();
	}
	
	public static void  inserisciContatto()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		System.out.print("Operazione INSERISCI CONTATTO selezionata. Digitare 'ok' per continuare. ");
		Scanner s=new Scanner(System.in);
		String st=s.next();
		String nomeContatto = null;
		String cognomeContatto = null;
		String email=null;
		String tell=null;
		String note=null;
		
	while(!st.equalsIgnoreCase("exit"))
	{
	
		System.out.print("Inserisci nome contatto: ");
		nomeContatto=s.next();
		
		System.out.println("Inserisci cognome contatto : ");
		cognomeContatto=s.next();
		
		System.out.println("Inserisci numero di telefono del contatto "+nomeContatto+" "+cognomeContatto+" :");
		tell=s.next();
		
		System.out.println("Inserisci email contatto : ");
		email=s.next();
		
		System.out.println("Inserisci note contatto : ");
		note=s.next();
		
		
		break;
	}	
	s.close();
	
	Contatto nuovoContatto= new Contatto();
	
	nuovoContatto.setName(nomeContatto);
	nuovoContatto.setSurname(cognomeContatto);
	nuovoContatto.setTelephone(tell);
	nuovoContatto.setEmail(email);
	nuovoContatto.setNote(note);
	
	em.persist(nuovoContatto);
	transaction.commit();
	em.close();
	
	System.out.println("Contatto "+nuovoContatto.getName()+" "+nuovoContatto.getSurname()+" aggiunto alla rubrica.");
	}
	
	public static void cancellaContatto()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<Contatto> contatti=new ArrayList<>();
        
		Contatto contatto=new Contatto();
		
		System.out.print("Operazione selezionata, inserire 'ok' ");
		Scanner s=new Scanner(System.in);
		String nomeContatto=null;
		String cognomeContatto=null;
		String st=s.next();
		int id=0;
		while(!st.equalsIgnoreCase("exit"))
		{
		
			System.out.print("Inserisci nome contatto: ");
			nomeContatto=s.next();
			
			
			
			System.out.println("Inserisci cognome contatto : ");
			cognomeContatto=s.next();
			break;
			
		}	
			s.close();
		for(Contatto c : contatti)
		{
			if(c.getName().equals(nomeContatto))
			{
				if(c.getSurname().equals(cognomeContatto)) contatto=c;
			}
		}
		
		entityManager.remove(contatto);
		transaction.commit();
		entityManager.close();
		
		System.out.println("Contatto "+contatto.getName()+" "+contatto.getSurname()+" eliminato dalla rubrica.");
		
	}
	public static List<Contatto> trovaDuplicati()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Contatto> contatti= vediListaContatti();
		List<Contatto> duplicati=new ArrayList<>();
		int conta=1;
		for(Contatto c : contatti)
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
	
	public static void unisciContattiDuplicati()
	{
		List<Contatto> duplicati=trovaDuplicati();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
	}
	public static void main(String[] args)
	{
		cancellaContatto();
		//System.out.println(vediListaContatti());
		//cercaContatto();
		//System.out.println(trovaDuplicati());
		
		//System.out.println("Benvenuto in rubrica, scegliere l'operazione: "+"/n"+"1)lista contatti"+"/n"+"2) cerca contatto"+"/n"+"3)cancella contatto"+"/n"
				//+"4)trova contatti duplicati"+"/n"+"5)unisci contatti duplicati"+"/n"+"6) inserisci contatto");
				//Scanner s=new Scanner(System.in);
				//String st=s.next();
				//switch(st)
				//{
				//case ("lista contatti") : vediListaContatti(); break;
				//case("cerca contatto"): cercaContatto();break;
				//case("cancella contatto"): cancellaContatto();break;
				//case("trova contatti duplicati"): System.out.println(trovaDuplicati()); break;
				//case("unisci contatti duplicati"): unisciContattiDuplicati();break;
				//case("inserisci contatto"): inserisciContatto();break;
				//}
				
				//s.close();
				//System.out.println("Sto uscendo dalla rubrica...");
				
	}

}
