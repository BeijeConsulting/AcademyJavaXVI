package nicole;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.neumann.rubrica.Contatto;
import it.beije.neumann.rubrica.HBMsessionFactory;

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
	
	public static void cancellaDuplicati()
	{
		
	}
	
	public static void main(String [] args)
	{
		//vediListaContatti();
		//cercaContatto("Mario","Rossi");
		//inserisciNuovoContatto("James","Bond","007123456","bond@gmail.com","Spia");
		//cancellaContatto("James","Bond");
		
		
	}

}
