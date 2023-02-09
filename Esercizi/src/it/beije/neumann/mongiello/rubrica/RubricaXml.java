package it.beije.neumann.mongiello.rubrica;

import java.io.File;
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

public class RubricaXml {
	
	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		Element documentElement = document.createElement("rubrica");
		document.appendChild(documentElement);
		
	
	//	contatto.setAttribute("COG", "Mauro");
		
		
		
		for( Contatto c: contatti ) {
			Element contatto = document.createElement("contatto");
			documentElement.appendChild(contatto);
			
			Element name = document.createElement("NAME");
			name.setTextContent(c.getName() );
			contatto.appendChild(name);
			
			Element surname = document.createElement("NAME");
			surname.setTextContent(c.getSurname() );
			contatto.appendChild(surname);
			
			Element telephone = document.createElement("TELEPHONE");
			telephone.setTextContent(c.getTelephone() );
			contatto.appendChild(telephone);
			
			Element email = document.createElement("EMAIL");
			email.setTextContent(c.getEmail() );
			contatto.appendChild(email);
			
			Element note = document.createElement("NOTE");
			note.setTextContent(c.getName() );
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
				transformer.transform(source, syso);
	}
}
