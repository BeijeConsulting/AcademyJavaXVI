package it.beije.neumann.mercuri.rubrica;

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
	public static List<Contatto> loadRubricaFromXML(String pathFile) {
		
		List<Contatto> contatti = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(pathFile);			
			Element rootElement = document.getDocumentElement();
			
			
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
			
		} catch (ParserConfigurationException parseConfEx) {
			parseConfEx.printStackTrace();
		
		} catch (IOException iOEx) {
			iOEx.printStackTrace();
		}
		 catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
			
		return contatti;
	}

	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) {
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			Element documentElement = document.createElement("contatti");
			document.appendChild(documentElement);
			
			for(Contatto contatto : contatti) {
				
				Element contattoEl = document.createElement("contatto");
				Element campoEl = null;
				
				if (contatto.getSurname() != null) {
					campoEl = document.createElement("cognome");
					campoEl.setTextContent(contatto.getSurname());
					contattoEl.appendChild(campoEl);					
				}
				if (contatto.getName() != null) {
					campoEl = document.createElement("nome");
					campoEl.setTextContent(contatto.getName());
					contattoEl.appendChild(campoEl);
				}
				if (contatto.getTelephone() != null) {
					campoEl = document.createElement("telefono");
					campoEl.setTextContent(contatto.getTelephone());
					contattoEl.appendChild(campoEl);
				}
				if (contatto.getEmail() != null) {
					campoEl = document.createElement("email");
					campoEl.setTextContent(contatto.getEmail());
					contattoEl.appendChild(campoEl);
				}
				if (contatto.getNote() != null) {
					campoEl = document.createElement("note");
					campoEl.setTextContent(contatto.getNote());
					contattoEl.appendChild(campoEl);
				}


				documentElement.appendChild(contattoEl);
					
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(new File(pathFile));

			// Output to console for testing
			StreamResult syso = new StreamResult(System.out);
			
			transformer.transform(source, syso);
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException parseConfEx) {
			parseConfEx.printStackTrace();
		
		} 

		catch (TransformerException transEx) {
			transEx.printStackTrace();
	
		} 
	}
	
	public static void main(String[] args)  {
		
		List<Contatto> contatti = loadRubricaFromXML("/temp/rubrica.xml");
		
		writeRubricaXML(contatti, "/temp/rubricaCopiata.xml");
	}

}
