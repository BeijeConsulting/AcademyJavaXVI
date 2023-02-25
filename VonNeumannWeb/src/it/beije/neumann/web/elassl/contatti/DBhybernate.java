package it.beije.neumann.web.elassl.contatti;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class DBhybernate implements ContactManager {
	
	DBhybernate(){
		Session session = HBMsessionFactory.openSession();
	}
	public List<Contatto> getContatti() throws ClassNotFoundException {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		return contatti;
	}

	@Override
	public int writeContatto(Contatto contatto) throws ClassNotFoundException {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(contatto);
		transaction.commit();
		session.close();
		return 0;
	}

	@Override
	public int updateContatto(Contatto toUpdate) throws ClassNotFoundException {
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE c.id = :updateID");
		query.setParameter("updateID",toUpdate.getId());
		List<Contatto> contatti = query.getResultList();
		Transaction transaction = session.beginTransaction();
		for (Contatto c: contatti) {
			transaction = session.beginTransaction();
			c.setName(toUpdate.getName());
			c.setSurname(toUpdate.getSurname());
			c.setEmail(toUpdate.getEmail());
			c.setTelephone(toUpdate.getTelephone());
			c.setNote(toUpdate.getNote());
			session.save(c);
			transaction.commit();
			System.out.println("Updated: "+contatti.get(0));
		}
		session.close();
		return 0;
	}

	@Override
	public List<Contatto> getDuplicates() throws ClassNotFoundException {
		String textQuery = "SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT 1 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)";
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery(textQuery);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		session.close();
		return contatti;
	}

	@Override
	public void mergeDuplicates() throws ClassNotFoundException {

		String textQuery = "SELECT c1 FROM Contatto as c1 WHERE EXISTS (SELECT 1 FROM Contatto as c2 WHERE c2.name = c1.name AND c2.surname = c1.surname AND c2.id <> c1.id)";
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery(textQuery);
		List<Contatto> contacts = query.getResultList();
		transaction.commit();
		
		List<Contatto> deleted = new ArrayList<>();
		for(Contatto contact1: contacts) {
			for(Contatto contact2: contacts) {
				if(!deleted.contains(contact1) && !deleted.contains(contact2) && contact1.equals(contact2) && contact1.getId() != contact2.getId()) {
					String telephone = (contact1.getTelephone() == null || contact1.getTelephone().length() == 0) ? contact2.getTelephone() : contact1.getTelephone();
					String email = (contact1.getEmail() == null || contact1.getEmail().length() == 0) ? contact2.getEmail() : contact1.getEmail();
					String note = (contact1.getNote() == null || contact1.getNote().length() == 0) ? contact2.getNote() : contact1.getNote();
					transaction = session.beginTransaction();
					contact1.setTelephone(telephone);
					contact1.setEmail(email);
					contact1.setNote(note);
					//updateContatto(contact1);
					//deleteContatto(contact2);
					session.delete(contact2);
					transaction.commit();

					deleted.add(contact2);
					transaction = session.beginTransaction();
					session.save(contact1);
					//System.out.println("deleted: "+ contact2);
					transaction.commit();
				}	
			}
		}
		session.close();
	}

	@Override
	public int deleteContatto(Contatto c) throws ClassNotFoundException {

		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Contatto toDelete = null;
		List<Contatto> contatti = this.getContatti();
		for(Contatto contatto: contatti) {
			if(contatto.getId()==c.getId()) {
				toDelete = contatto;
				break;
			}
		}
		if(toDelete!=null)
			session.delete(toDelete);
		transaction.commit();
		session.close();
		return 0;
	}
	@Override
	public List<Contatto> getContatto(Contatto contact) {
		Session session = HBMsessionFactory.openSession();
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE c.name = :name AND c.surname = :surname");
		query.setParameter("name",contact.getName());
		query.setParameter("surname",contact.getSurname());
		List<Contatto> contatti = query.getResultList();
		return contatti;
	}

}
