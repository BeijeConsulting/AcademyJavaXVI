package it.beije.neumann.nido.gestorerubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public class RubricaJPACriteriaManager implements RubricaQLManager { // Sistemare

	private static RubricaJPACriteriaManager criteriaManager;
	private EntityManager entityManager = null;
	private EntityTransaction transaction = null;
	private CriteriaBuilder criteriaBuilder = null;

	private RubricaJPACriteriaManager() {
	}

	public static RubricaJPACriteriaManager getJPACriteriaManager() {

		if (criteriaManager == null)
			criteriaManager = new RubricaJPACriteriaManager();

		return criteriaManager;
	}

	private void launchEntityManager() {
		entityManager = JPAentityFactory.getEntityManager("Esercizi");
		transaction = entityManager.getTransaction();
	}

	private void closeEntityManager() {
		entityManager.close();
	}

	private void fetchCriteriaBuilder() {
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public void showRubrica(String orderBy, String onWhat) {
		launchEntityManager();
		transaction.begin();

		fetchCriteriaBuilder();

		CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);
		Root<Contact> rootSelect = criteriaQuery.from(Contact.class);

		criteriaQuery.select(rootSelect);

		switch (orderBy) {
		case "ASC":
			criteriaQuery.orderBy(criteriaBuilder.asc(rootSelect.get(onWhat)));
			break;
		case "DESC":
			criteriaQuery.orderBy(criteriaBuilder.desc(rootSelect.get(onWhat)));
			break;
		}

		Query query = entityManager.createQuery(criteriaQuery);
		List<Contact> contacts = query.getResultList();

		for (Contact c : contacts)
			System.out.println(c + "\n");

		transaction.commit();
		closeEntityManager();
	}

	public List<Contact> searchContact(String name, String surname) {
		launchEntityManager();
		transaction.begin();

		fetchCriteriaBuilder();

		CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);
		Root<Contact> rootSelect = criteriaQuery.from(Contact.class);

		Predicate nameEqualsInput = criteriaBuilder.equal(rootSelect.get("name"), name);
		Predicate surnameEqualsInput = criteriaBuilder.equal(rootSelect.get("surname"), surname);

		criteriaQuery.select(rootSelect);

		if (!surname.isEmpty() && !name.isEmpty()) {
			criteriaQuery.where(criteriaBuilder.and(nameEqualsInput, surnameEqualsInput));
		} else if (!surname.isEmpty()) {
			criteriaQuery.where(surnameEqualsInput);
		} else if (!name.isEmpty()) {
			criteriaQuery.where(nameEqualsInput);
		}

		Query query = entityManager.createQuery(criteriaQuery);
		List<Contact> contacts = query.getResultList();

		transaction.commit();
		closeEntityManager();

		return contacts;
	}

	public void addContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		entityManager.persist(contact);

		transaction.commit();
		closeEntityManager();

	}

	public void editContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		fetchCriteriaBuilder();

		CriteriaUpdate<Contact> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Contact.class);

		Root<Contact> rootUpdate = criteriaUpdate.from(Contact.class);

		Predicate idEqualsInput = criteriaBuilder.equal(rootUpdate.get("id"), contact.getId());

		criteriaUpdate.set("surname", contact.getSurname());
		criteriaUpdate.set("name", contact.getName());
		criteriaUpdate.set("telephone", contact.getTelephone());
		criteriaUpdate.set("email", contact.getEmail());
		criteriaUpdate.set("note", contact.getNote());

		criteriaUpdate.where(idEqualsInput);

		entityManager.createQuery(criteriaUpdate).executeUpdate();

		transaction.commit();
		closeEntityManager();

	}

	public void deleteContact(Contact contact) {
		launchEntityManager();
		transaction.begin();

		fetchCriteriaBuilder();

		CriteriaDelete<Contact> criteriaDelete = criteriaBuilder.createCriteriaDelete(Contact.class);

		Root<Contact> rootDelete = criteriaDelete.from(Contact.class);

		Predicate idEqualsInput = criteriaBuilder.equal(rootDelete.get("id"), contact.getId());

		criteriaDelete.where(idEqualsInput);

		entityManager.createQuery(criteriaDelete).executeUpdate();

		transaction.commit();
		closeEntityManager();

	}

	public List<Contact> searchDuplicate() {
		launchEntityManager();
		transaction.begin();

		fetchCriteriaBuilder();

		CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);
		Subquery<Contact> subQuery = criteriaQuery.subquery(Contact.class);

		Root<Contact> c1 = criteriaQuery.from(Contact.class);
		Root<Contact> c2 = subQuery.from(Contact.class);

		Predicate sameName = criteriaBuilder.equal(c1.get("name"), c2.get("name"));
		Predicate sameSurname = criteriaBuilder.equal(c1.get("surname"), c2.get("surname"));
		Predicate differentId = criteriaBuilder.notEqual(c1.get("id"), c2.get("id"));

		Order ascBySurname = criteriaBuilder.asc(c1.get("surname"));
		Order ascById = criteriaBuilder.asc(c1.get("id"));

		subQuery.select(c2);
		subQuery.where(criteriaBuilder.and(sameName, sameSurname, differentId));

		criteriaQuery.select(c1);
		criteriaQuery.where(criteriaBuilder.exists(subQuery)).orderBy(ascBySurname, ascById);

		Query query = entityManager.createQuery(criteriaQuery);
		List<Contact> duplicates = query.getResultList();

		transaction.commit();
		closeEntityManager();

		return duplicates;
	}

	public void mergeDuplicate(Contact base, Contact dup) {
		String newVal = null;

		// Telephone
		if (!base.getTelephone().contains(dup.getTelephone())) {
			newVal = FilesUtils.formatNewField(base.getTelephone(), dup.getTelephone());
			base.setTelephone(newVal);
		}

		// Email
		if (!base.getEmail().contains(dup.getEmail())) {
			newVal = FilesUtils.formatNewField(base.getEmail(), dup.getEmail());
			base.setEmail(newVal);
		}

		// Note
		if (!base.getNote().contains(dup.getNote())) {
			newVal = FilesUtils.formatNewField(base.getNote(), dup.getNote());
			base.setNote(newVal);
		}

		this.deleteContact(dup);
		this.editContact(base);

	}

}
