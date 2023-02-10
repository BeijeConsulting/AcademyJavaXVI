package it.beije.neumann.elassl.feb9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

import it.beije.neumann.elassl.feb8.Contatto;

public class XMLmanager {
	/*
	public List<Contatto> loadRubricaFromXML(String pathFile) {...}
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) {
	}
	*/
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
	

	
	public List<Contatto> loadRubricaFromXML(String pathFile) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(pathFile);
		
		Element rootElement = document.getDocumentElement();

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
		return contatti;
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
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		File file = new File(pathFile);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		if (file.exists()) {
			List<Contatto> oldContatti = loadRubricaFromXML(pathFile);
			contatti.addAll(0, oldContatti);
		}
		for (Contatto c: contatti) {
			Element contatto = document.createElement("contatto");
			Element cognome = document.createElement("cognome");
			cognome.setTextContent(c.getSurname());
			Element nome = document.createElement("nome");
			nome.setTextContent(c.getName());
			Element telefono = document.createElement("telefono");
			telefono.setTextContent(c.getTelephone());
			Element email = document.createElement("email");
			email.setTextContent(c.getEmail());
			Element note = document.createElement("note");
			note.setTextContent(c.getNote());

			contatto.appendChild(cognome);
			contatto.appendChild(nome);
			contatto.appendChild(telefono);
			contatto.appendChild(email);
			contatto.appendChild(note);
			document.appendChild(contatto);
			System.out.println("Added "+contatto);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(file);

		transformer.transform(source, result);

	}
	
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		
		
	}

}
