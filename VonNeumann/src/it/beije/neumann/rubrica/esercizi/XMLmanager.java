package it.beije.neumann.rubrica.esercizi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.neumann.rubrica.Contatto;

public class XMLmanager {
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		File file = new File("./src/it/beije/neumann/rubrica/esercizi/rubrica.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		
		Element root = document.getDocumentElement();
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		List<Element> elements = getChildElements(root);
		Contatto contatto = null;
		for (Element el : elements) {
			contatto = new Contatto();
			System.out.println("eta' : " + el.getAttribute("eta"));
			
			List<Element> values = getChildElements(el);
			for (Element v : values) {
				System.out.println("node name: " + v.getNodeName());
				switch (v.getNodeName()) {
				case "nome":
					contatto.setName(v.getTextContent());
					break;
				case "cognome":
					contatto.setSurname(v.getTextContent());
					break;
				case "telefono":
					contatto.setTelephone(v.getTextContent());
					break;
				case "email":
					contatto.setEmail(v.getTextContent());
					break;
				case "note":
					contatto.setNote(v.getTextContent());
					break;
				}
			}
			
			contatti.add(contatto);
		}

		System.out.println(contatti);
	}
	
	public static List<Element> getChildElements(Element e) {
		List<Element> elements = new ArrayList<Element>();
		NodeList childNodes = e.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i ++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				elements.add((Element) node);
			}
		}
		
		return elements;
	}



}