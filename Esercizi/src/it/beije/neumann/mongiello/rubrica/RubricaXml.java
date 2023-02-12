package it.beije.neumann.mongiello.rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class RubricaXml {
	
	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element documentElement = document.createElement("rubrica");
		document.appendChild(documentElement);
		
		for( Contatto c: contatti ) {
			Element contatto = document.createElement("contatto");
			documentElement.appendChild(contatto);
			
			Element name = document.createElement("NAME");
			name.setTextContent(c.getName() );
			contatto.appendChild(name);
			
			Element surname = document.createElement("SURNAME");
			surname.setTextContent(c.getSurname() );
			contatto.appendChild(surname);
			
			Element telephone = document.createElement("TELEPHONE");
			telephone.setTextContent(c.getTelephone() );
			contatto.appendChild(telephone);
			
			Element email = document.createElement("EMAIL");
			email.setTextContent(c.getEmail() );
			contatto.appendChild(email);
			
			Element note = document.createElement("NOTE");
			note.setTextContent(c.getNote() );
			contatto.appendChild(note);

		}
		
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				
				StreamResult result = new StreamResult(new File(pathFile));

				// Output to console for testing
				StreamResult syso = new StreamResult(System.out);

				transformer.transform(source, result);
			//	transformer.transform(source, syso);
	}

	public static List<Contatto> loadRubricaFromXML(String pathFile) throws ParserConfigurationException, SAXException, IOException {
		String name = null;
		String surname = null;
		String telephone = null;
		String email = null;
		String note = null;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);
		
		Element rootElement = document.getDocumentElement();
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		List<Element> elements = getChildElements(rootElement);
		for (Element el : elements) {
			
			List<Element> values = getChildElements(el);
			for (Element v : values) {
				//System.out.println("node name: " + v.getNodeName());
				switch (v.getNodeName()) {
				case "NAME":
					name = v.getTextContent();
					break;
				case "SURNAME":
					surname = v.getTextContent();
					break;
				case "TELEPHONE":
					telephone = v.getTextContent();
					break;
				case "EMAIL":
					email = v.getTextContent();
					break;
				case "NOTE":
					note = v.getTextContent();
					break;
				}
			}
			contatti.add(new Contatto ( name, surname, telephone, email, note ));
	}
		return contatti;
		
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