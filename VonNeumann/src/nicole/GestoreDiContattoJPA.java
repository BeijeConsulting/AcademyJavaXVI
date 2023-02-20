package nicole;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import it.beije.neumann.rubrica.*;
public class GestoreDiContattoJPA 
{
	public static void vediListaContatti()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumann");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<it.beije.neumann.rubrica.Contatto> contatti = query.getResultList();
		
		//for (it.beije.neumann.rubrica.Contatto c : contatti) {			
			//System.out.println(c);		
			//}
		System.out.println(contatti);
		transaction.commit();
		
		
		
		
	}
	
	public static void cercaContatto()
	{
		
	}
	
	public static void main(String[] args)
	{
		vediListaContatti();
	}

}
