package it.beije.neumann.vanoli.rubrica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException {
		List<Contatto> contatti = CSVManager.loadRubricaFromCSV("/temp/rubrica.csv", ";");
        XMLManager.writeRubricaXML(contatti, "/temp/rubricona.xml");
	}

}
