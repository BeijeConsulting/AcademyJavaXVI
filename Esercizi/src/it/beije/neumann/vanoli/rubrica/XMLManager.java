package it.beije.neumann.vanoli.rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManager {
	
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
	
	public static void addProperty(Document doc, Element elemContact, String tag, String value) {
		if (value.equals(""))
			return;
		Element property = doc.createElement(tag);
		property.setTextContent(value);
		elemContact.appendChild(property);
	}

	public static List<Contatto> loadRubricaFromXML(String pathFile) throws ParserConfigurationException, IOException, SAXException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);
		
		Element rootElement = document.getDocumentElement();
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		List<Element> elements = getChildElements(rootElement);
		Contatto contatto = null;
		for (Element el : elements) {
			contatto = new Contatto();
			List<Element> values = getChildElements(el);
			for (Element v : values) {
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
		return contatti;
	}
	
	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		if (new File(pathFile).exists()) {
			List<Contatto> vecchiContatti = loadRubricaFromXML(pathFile);
			vecchiContatti.addAll(contatti);
			contatti = vecchiContatti;
		}
		Document document = documentBuilder.newDocument();
		Element documentElement = document.createElement("rubrica");
		document.appendChild(documentElement);
		for (Contatto c: contatti) {
			Element e = document.createElement("contatto");
			addProperty(document, e, "nome", c.getName());
			addProperty(document, e, "cognome", c.getSurname());
			addProperty(document, e, "telefono", c.getTelephone());
			addProperty(document, e, "email", c.getEmail());
			addProperty(document, e, "note", c.getNote());
			documentElement.appendChild(e);
		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(new File(pathFile));

		transformer.transform(source, result);
	}	
}
