package it.beije.neumann.parserxml.elassl_verzaschi;

public class DocumentEV{
	private Element rootElement;
	public Element getRootElement(){ //torna l'elemento root
		return rootElement;
	}
	public void setRootElement(Element rootElement) {
		this.rootElement=rootElement;
	}
	
/*
 * getRootElement() 
getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
getTagName() //torna il nome del tag
getTextContent() //torna il contenuto del tag
getAttributes() //torna l'elenco degli attributi dell'elemento
getAttribute(String attribute) //torna il valore dell'attributo specificato
 */
}
