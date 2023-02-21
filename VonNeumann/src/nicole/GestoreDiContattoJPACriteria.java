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
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import it.beije.neumann.rubrica.HBMsessionFactory;

public class GestoreDiContattoJPACriteria 
{
	public static List<Contatto> vediListaContatti()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//creo il Criteria Builder
		CriteriaBuilder cb= em.getCriteriaBuilder();
		
		CriteriaQuery<Contatto> query= cb.createQuery(Contatto.class);
		//creo la radice della query
		Root<Contatto> root=query.from(Contatto.class);
		
		//SELECT su tutti i contatti del database
		query.select(root);
		Query q = em.createQuery(query);
		
		List<Contatto> result = q.getResultList();
		transaction.commit();
		em.close();
		return result;
		
	}
	
	public static void vediContattiPerId()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//creo il Criteria Builder
		CriteriaBuilder cb= em.getCriteriaBuilder();
		
		CriteriaQuery<Contatto> query= cb.createQuery(nicole.Contatto.class);
		//creo la radice della query
		Root<Contatto> root=query.from(nicole.Contatto.class);
		
		//SELECT su tutti i contatti del database
		query.select(root.get("id"));
		Query q = em.createQuery(query);
	
		List<Contatto> result = q.getResultList();
		System.out.print(result);
		transaction.commit();
		em.close();
	}
	
	public static void cercaContatto()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//creo il Criteria Builder
		CriteriaBuilder cb= em.getCriteriaBuilder();
		
		CriteriaQuery<Contatto> query= cb.createQuery(nicole.Contatto.class);
		//creo la radice della query
		Root<Contatto> root=query.from(nicole.Contatto.class);
		
	
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
	
	query.select(root).where(root.get("name").in("contatti", nomeContatto)).where(root.get("surname").in("contatti",cognomeContatto));
	Query q = em.createQuery(query);
	
	List<Contatto> result = q.getResultList();
	System.out.print(result);
	
	transaction.commit();
	em.close();
  }	
	
	public static void inserisciContatto()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//creo il Criteria Builder
		CriteriaBuilder cb= em.getCriteriaBuilder();
		
		CriteriaQuery<Contatto> query= cb.createQuery(nicole.Contatto.class);
		//creo la radice della query
		Root<Contatto> root=query.from(nicole.Contatto.class);
		
		System.out.print("Avvio Scanner... ");
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
		
	
	nicole.Contatto nuovoContatto=new Contatto();
	
	nuovoContatto.setName(nomeContatto);
	nuovoContatto.setSurname(cognomeContatto);
	nuovoContatto.setTelephone(tell);
	nuovoContatto.setEmail(email);
	nuovoContatto.setNote(note);
	

	CriteriaUpdate<Contatto> uq = cb.createCriteriaUpdate(nicole.Contatto.class);
	Root<Contatto> rootEntity2 = uq.from(Contatto.class);

	Contatto contatto=new Contatto();
    
     em.createQuery(uq).executeUpdate();  
	
	}
	
	
	
	public static void cancellaContatto()
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//creo il Criteria Builder
		CriteriaBuilder cb= em.getCriteriaBuilder();
		

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
		 
        // create delete
        CriteriaDelete<Contatto> delete = cb.createCriteriaDelete(Contatto.class);
 
        // set the root class
        Root root = delete.from(Contatto.class);
 
        // set where clause
          delete.where(root.get("name").in("contatti", nomeContatto)).where(root.get("surname").in("contatti",cognomeContatto));
 
        Query q = em.createQuery(delete);
    	
    	q.executeUpdate();
    
    	transaction.commit();
    	em.close();
    }
		
		public static List<Contatto> trovaDuplicati()
		{
			List<Contatto> contatti=vediListaContatti();
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
			
		return duplicati;
			
		}
	
		public static void unisciDuplicati()
		{
			List<Contatto> duplicati=trovaDuplicati();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
			EntityManager em = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			//creo il Criteria Builder
			CriteriaBuilder cb= em.getCriteriaBuilder();
			//creo il criteria update
			CriteriaUpdate update=cb.createCriteriaUpdate(nicole.Contatto.class);
			Root<Contatto> root= update.from(nicole.Contatto.class);
			
			 List<Integer> idDuplicati=new ArrayList<>();
				int conta=1;
				
				
				for(Contatto c : duplicati)
				{
					for(int i=conta; i<duplicati.size();i++)
					{
						if(c.getName().equals(duplicati.get(i).getName()))
						{
							if(c.getSurname().equals(duplicati.get(i).getSurname())) {
								
								
								idDuplicati.add(c.getId());
							}
						}
						
					}
					conta++;
				}
			
			int conta1=1;
			for(Contatto c : duplicati)
			{
				for(int i=conta1; i<duplicati.size();i++)
				{
					if(c.getName().equals(duplicati.get(i).getName())) 
					{
						//due numeri di telefono non c'entrano
						//if(!(c.getTelephone().equals(duplicati.get(i).getTelephone()))) {
						//String tell=c.getTelephone();
						//if(tell.equals("null") || tell.equals(null)) tell="";
						//if(tell2.equals("null") || tell2.equals(null)) tell2="";
						//String tell2=duplicati.get(i).getTelephone();
							//UPDATE
							//statement=connection.prepareStatement("UPDATE contatti set telefono= '"+tell+","+tell2+"' WHERE id= '"+c.getId()+"'");
						    //rows=statement.executeUpdate();
							
						
						//}
						
						if(!(c.getEmail().equals(duplicati.get(i).getEmail()))) {
							String email=c.getEmail();
							String email2=duplicati.get(i).getEmail();
							if(email.equals("null") || email.equals(null)) email="";
							if(email2.equals("null") || email2.equals(null)) email2="";
							c.setEmail(email+","+email2);
							update.set(email, email+","+email2);
							em.createQuery(update).executeUpdate();
							
						}
							
						if(!(c.getNote().equals(duplicati.get(i).getNote()))) {
							String note=c.getNote();
							String note2=duplicati.get(i).getNote();
							if(note.equals("null") || note.equals(null)) note="";
							if(note2.equals("null") || note2.equals(null)) note2="";
							c.setNote(note+","+note2);
							update.set(note, note+","+note2);
							em.createQuery(update).executeUpdate();
							
						}
							
					
					}
					conta1++;
				}
				
				 
			
				//faccio un criteria delete
				CriteriaDelete delete= cb.createCriteriaDelete(Contatto.class);
				Root<Contatto> root1=delete.from(Contatto.class);
				
				for(int i=0;i<idDuplicati.size();i++)
				{
					delete.where(root.get("id").in("contatti", idDuplicati.get(i)));
					em.createQuery(delete).executeUpdate();
					
				}
				
				
				
				transaction.commit();
				em.close();
				
			}
			
		}
	
		
		public static void main(String[] args)
	{
		//System.out.println(vediListaContatti());
		
		
		//vediContattiPerId();
		//cercaContatto();
		//cancellaContatto();
		
		//System.out.println(trovaDuplicati());
			
	
		//unisciDuplicati();
			
	}

}
