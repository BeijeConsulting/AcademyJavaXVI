package nicole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.neumann.rubrica.HBMsessionFactory;
import it.beije.neumann.rubrica.Contatto;
public class GestoreDiContattoHBM 
{
	public static void vediListaContatti()
	{
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		System.out.println(contatti);
		transaction.commit();
	}
	
	
	
	public static void cercaContatto(String nome, String cognome)
	{
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		//System.out.println(contatti);
		
		Contatto trovato=null;
	
		for(Contatto c : contatti)
		{
			if(c.getName().equals(nome))
			{
				if (c.getSurname().equals(cognome)) trovato=c;
					
			}
		}
		

		System.out.println(trovato);
		
		transaction.commit();

	
	}
	
	public static void inserisciNuovoContatto(String nomeContatto, String cognomeContatto,String numeroTell, String emailContatto, String note)
	{

		Session session = HBMsessionFactory.openSession();
	
		Transaction transaction = session.beginTransaction();
				
		
		Contatto contatto = new Contatto();
		
		contatto.setName(nomeContatto);
		contatto.setSurname(cognomeContatto);
		contatto.setEmail(emailContatto);
		contatto.setNote(note);
		contatto.setTelephone(numeroTell);
		session.save(contatto);
		transaction.commit();
		
		System.out.println("Contatto "+nomeContatto+" "+cognomeContatto+" aggiunto alla rubrica.");
	}
	
	public static void cancellaContatto(String nome,String cognome)
	{
		Session session= HBMsessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		Contatto contatto=new Contatto();
		
		for(Contatto c : contatti)
		{
			if(c.getName().equals(nome))
			{
				if(c.getSurname().equals(cognome)) contatto=c;
			}
		}
		
		
		session.delete(contatto);
		transaction.commit();
		
		
		System.out.println("Contatto "+nome+" "+cognome+" eliminato dalla rubrica.");
	}
	
	public static List<Contatto> trovaDuplicati()
	{
		Session session = HBMsessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query<Contatto> query= session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti=query.getResultList();
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
		
		System.out.println(duplicati);
		return duplicati;
	}
	
	
	public static void unisciDuplicati()
	{
		Session session= HBMsessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		List<Contatto> duplicati=trovaDuplicati();
		
		
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
						session.save(c);
						
					}
						
					if(!(c.getNote().equals(duplicati.get(i).getNote()))) {
						String note=c.getNote();
						String note2=duplicati.get(i).getNote();
						if(note.equals("null") || note.equals(null)) note="";
						if(note2.equals("null") || note2.equals(null)) note2="";
						c.setNote(note+","+note2);
						session.save(c);
						
					}
						
				
				}
				conta1++;
			}
		
			for(int i=0;i<duplicati.size();i++)
			{
				session.delete(duplicati.get(i));
			}
			
			
			
			
			transaction.commit();
			
		}
		
	}
	
	
	public static void main(String [] args)
	{
		//vediListaContatti();
		//cercaContatto("Mario","Rossi");
		//inserisciNuovoContatto("James","Bond","007123456","bond@gmail.com","Spia");
		//cancellaContatto("James","Bond");
		trovaDuplicati();
		//unisciDuplicati();
		
		
	}

}
