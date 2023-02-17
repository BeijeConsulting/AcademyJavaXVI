package it.beije.neumann.elassl.contatti;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class DBhybernate implements ContactManager {

	@Override
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
		return 0;
	}

	@Override
	public int updateContatto(Contatto c) throws ClassNotFoundException {
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Contatto toEdit = null;
		List<Contatto> contatti = this.getContatti();
		for(Contatto contatto: contatti) {
			if(contatto.getId()==c.getId()) {
				toEdit = contatto;
				toEdit.setName(c.getName());
				toEdit.setSurname(c.getSurname());
				toEdit.setEmail(c.getEmail());
				toEdit.setTelephone(c.getTelephone());
				toEdit.setNote(c.getNote());
				break;
			}
		}
		if(toEdit!=null)
			session.save(toEdit);
		transaction.commit();
		return 0;
	}

	@Override
	public List<Contatto> getDuplicates() throws ClassNotFoundException {
		String textQuery = "SELECT * FROM contatti as c1 WHERE EXISTS (SELECT 1 FROM contatti as c2 WHERE c2.nome = c1.nome AND c2.cognome = c1.cognome AND c2.id <> c1.id);";
		Session session = HBMsessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Contatto> query = session.createQuery(textQuery);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		return contatti;
	}

	@Override
	public void mergeDuplicates() throws ClassNotFoundException {
		List<Contatto> contacts=getDuplicates();
		for(Contatto contact1: contacts) {
			for(Contatto contact2: contacts) {
				if(contact1.getId()!=-1 && contact2.getId()!=-1 && contact1.equals(contact2) && contact1.getId() != contact2.getId()) {
					String telephone = (contact1.getTelephone() == null || contact1.getTelephone().length() == 0) ? contact2.getTelephone() : contact1.getTelephone();
					String email = (contact1.getEmail() == null || contact1.getEmail().length() == 0) ? contact2.getEmail() : contact1.getEmail();
					String note = (contact1.getNote() == null || contact1.getNote().length() == 0) ? contact2.getNote() : contact1.getNote();
					contact1.setTelephone(telephone);
					contact1.setEmail(email);
					contact1.setNote(note);
					updateContatto(contact1);
					deleteContatto(contact2);
					contact2.setId(-1);
				}	
			}
		}
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
		return 0;
	}

}
