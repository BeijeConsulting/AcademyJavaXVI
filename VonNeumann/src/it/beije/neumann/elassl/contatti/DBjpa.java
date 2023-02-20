package it.beije.neumann.elassl.contatti;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.neumann.rubrica.Contatto;

public class DBjpa implements ContactManager {

	@Override
	public List<Contatto> getContatti() throws ClassNotFoundException {
		EntityManager entityManager = EMfactory.openEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		return contatti;
	}

	@Override
	public int writeContatto(Contatto contatto) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateContatto(Contatto contact) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contatto> getDuplicates() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergeDuplicates() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteContatto(Contatto contact) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
