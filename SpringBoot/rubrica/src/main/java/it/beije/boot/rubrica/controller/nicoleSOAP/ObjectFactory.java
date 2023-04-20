package it.beije.boot.rubrica.controller.nicoleSOAP;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;
import it.beije.boot.rubrica.model.nicole.Contact;
import it.beije.boot.rubrica.controller.nicoleSOAP.GetNames;


public class ObjectFactory {
	private final static QName _GetNamesResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getNamesResponse");
    private final static QName _AddContactResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "addContactResponse");
    private final static QName _GetContacts_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContacts");
    private final static QName _GetContactsByNameResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsByNameResponse");
    private final static QName _GetContactsResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsResponse");
    private final static QName _AddContact_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "addContact");
    private final static QName _GetContactsByName_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsByName");
    private final static QName _GetNames_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getNames");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beije.ws.jaxws.contacts.client
     * 
     */
    public ObjectFactory() {
    }

    
    public GetNames createGetNames() {
        return new GetNames();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getNames")
    public JAXBElement<GetNames> createGetNames(GetNames value) {
        return new JAXBElement<GetNames>(_GetNames_QNAME, GetNames.class, null, value);
    }

}
