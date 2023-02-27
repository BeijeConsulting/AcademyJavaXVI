package nicole;

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
import it.beije.neumann.rubrica.Contatto;
/**
 * scrivo una mia rubrica su un file xml
 * @author nverz
 *
 */



public class XMLManager 
{
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

	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) throws SAXException, IOException, TransformerException 
	{
		
	
		
		try {
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			Element rootElement = document.createElement("rubrica");
			
			document.appendChild(rootElement);
			
			
			
			for(Contatto c: contatti)
			{
				Element elCont= document.createElement("contatto");
				rootElement.appendChild(elCont);
				
				Element elNome= document.createElement("nome");
				Element elSurn=document.createElement("cognome");
				Element elTel=document.createElement("telefono");
				Element elMail=document.createElement("Email");
				Element elNote= document.createElement("note");
				
				
			
				elNome.setTextContent(c.getName());
				elCont.appendChild(elNome);
				
				elSurn.setTextContent(c.getSurname());
				elCont.appendChild(elSurn);
				
				elTel.setTextContent(c.getTelephone());
				elCont.appendChild(elTel);
				
				elMail.setTextContent(c.getEmail());
				elCont.appendChild(elMail);
				
				elNote.setTextContent(c.getNote());
				elCont.appendChild(elNote);
				
				
				
				//scrivo sul file rubrica.xml
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				
				StreamResult result = new StreamResult(new File(pathFile));

				// Output to console for testing
				StreamResult syso = new StreamResult(System.out);
				TransformerFactory transformerFactory1 = TransformerFactory.newInstance();
				Transformer transformer1 = transformerFactory1.newTransformer();
				DOMSource source1 = new DOMSource(document);
				
				StreamResult result1 = new StreamResult(new File(pathFile));
				
				StreamResult syso1 = new StreamResult(System.out);

				transformer.transform(source1, result1);
				transformer.transform(source1, syso1);
				
			}
			


			
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		}
		
}

	
	public static void main(String [] args) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		List<Contatto> contatti= new ArrayList<>();
		Contatto c1= new Contatto();
		c1.setName("Nicole");
		c1.setSurname("Verzaschi");
		c1.setEmail("nverzaschi@gmail.com");
		c1.setTelephone("3349003586");
		c1.setNote("mamma");
		contatti.add(c1);
		
		Contatto c2= new Contatto();
		c2.setName("Lidia");
		c2.setSurname("Mometti");
		c2.setTelephone("nessun telefono");
		c2.setEmail("lilli@gmail");
		c2.setNote("");
		contatti.add(c2);
		
		writeRubricaXML(contatti,"C:\\Users\\nverz\\Music\\esercizio.\\rubrica.xml");
		
	}

}
