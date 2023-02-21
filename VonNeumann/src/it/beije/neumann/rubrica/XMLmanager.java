package it.beije.neumann.rubrica;

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

import nicole.Contatto;

public class XMLmanager {
	
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

	public static void readRubricaXML(String[] args) throws ParserConfigurationException, IOException, SAXException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("/temp/rubrica.xml");
		
		Element rootElement = document.getDocumentElement();
		
//		NodeList contatti = rootElement.getElementsByTagName("contatto");
//		System.out.println("num contatti: " + contatti.getLength());
//		for (int i = 0; i < contatti.getLength(); i ++) {
//			Element e = (Element) contatti.item(i);
//			System.out.println("NodeName: " + e.getNodeName());
//			System.out.println("num contatti interni: " + e.getElementsByTagName("contatto").getLength());
//		}
		
//		NodeList childNodes = rootElement.getChildNodes();
//		System.out.println("num childNodes: " + childNodes.getLength());
//		for (int i = 0; i < childNodes.getLength(); i ++) {
//			Node node = childNodes.item(i);
//			if (node instanceof Element) {
//				Element e = (Element) node;
//				System.out.println("NodeName: " + e.getNodeName());
//			}
//			System.out.println("node: " + node.getNodeName());
//		}
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		List<Element> elements = getChildElements(rootElement);
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
	
	
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element documentElement = document.createElement("cani");
		document.appendChild(documentElement);
		
		Element cane1 = document.createElement("cane");
		Element razza1 = document.createElement("razza");
		cane1.setAttribute("nome", "Pluto");
		cane1.setAttribute("peso", "15");
		cane1.setAttribute("eta", "5");
		razza1.setTextContent("Pastore Tedesco");
		cane1.appendChild(razza1);
		documentElement.appendChild(cane1);
		
		Element cane2 = document.createElement("cane");
		Element razza2 = document.createElement("razza");
		cane2.setAttribute("nome", "Jack");
		cane2.setAttribute("peso", "60");
		cane2.setAttribute("eta", "2");
		razza2.setTextContent("Alano");
		cane2.appendChild(razza2);
		documentElement.appendChild(cane2);
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(new File("/temp/cani.xml"));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);

		//System.out.println("File saved!");	
	}

}
