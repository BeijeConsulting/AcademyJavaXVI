package it.beije.neumann.nido.gestorerubrica;

import java.util.List;

public interface RubricaQLManager {

	public abstract void showRubrica(String orderBy, String onWhat);

	public abstract List<Contact> searchContact(String name, String surname);

	public abstract void addContact(Contact contact);

	public abstract void editContact(Contact contact);

	public abstract void deleteContact(Contact contact);

	public abstract List<Contact> searchDuplicate();

	public abstract void mergeDuplicate();
}
